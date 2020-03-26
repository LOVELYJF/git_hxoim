package com.hxoim.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.hxoim.common.Reflector.PakageHelpper;
import com.hxoim.common.Reflector.ReflectHelpper;
import com.hxoim.common.hxThread.hxBaseThreadWithQueue;
import com.hxoim.common.hxannotation.ColumnAnnotation;
import com.hxoim.common.hxannotation.TableAnnotation;
import com.hxoim.common.utils.*;
import com.hxoim.general.select.entity.SqlVo;
import com.hxoim.general.select.mapper.SelectMapper;
import com.hxoim.support.DataChangedLog.entity.CfDatachangedlog;
import com.hxoim.support.DataChangedLog.entity.DataChangedType;
import com.hxoim.support.DataChangedLog.mapper.CfDatachangedlogMapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.*;
import java.util.regex.Matcher;

/**
 * @description:拦截数据增删改，用于保存数据修改日志，目前不支持批量操作，批量插入，批量删除（ID列表）
 * @author:杨波
 * @date:2019-06-27
 **/
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class MybatisExecutorInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(MybatisExecutorInterceptor.class);
    private CfDatachangedlogMapper dclMapper = MybatisUtils.getMapper(CfDatachangedlogMapper.class);
    private SelectMapper selectService = MybatisUtils.getMapper(SelectMapper.class);
    private hxBaseThreadWithQueue<MybatisObjectPack> logThread;

    public Object intercept(Invocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();

        if (methodName.equals("query")) {
            PrintQuerySQL(invocation);

        } else if (methodName.equals("update")) {
            RecordLog(invocation);
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }

    private void PrintQuerySQL(Invocation invocation) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            MybatisObjectPack mop = new MybatisObjectPack();
            getMybatisObject(invocation, mop);

            String sql = showSql(mop.configuration, mop.boundSql);
            log.info(sql);
        }
        catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }
    /**
     * @description:将日志保存放入队列，在线程中执行修改数据获取、外键转换和日志数据存储
     * @author:杨波
     * @date:2019-06-26 * @param invocation
     * @return:void
     **/
    private void RecordLog(Invocation invocation)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        //将RequestAttributes对象设置为子线程共享，否则在线程中获取不到ServletRequestAttributes
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        RequestContextHolder.setRequestAttributes(sra, true);

        MybatisObjectPack mop = new MybatisObjectPack();
        getMybatisObject(invocation, mop);

        if (logThread == null) {
            logThread = new hxBaseThreadWithQueue<MybatisObjectPack>(this, "SaveDataChangedLog");
            logThread.start();
        }
        logThread.Offer(mop);
    }

    /**
     * @description:保存数据修改日志，通过反射获取数据库字段和值，通过注解获取有外键的字段的外键值（如字典项的中文）
     * @author:杨波
     * @date:2019-06-05 * @param invocation
     * @return:void
     **/
    public void SaveDataChangedLog(MybatisObjectPack mop)
            throws NoSuchMethodException {

        //数据可能已经被其他人删除
        if (mop.cls == null) return;
        //判断是否有表注解，没有就返回
        TableAnnotation ans = mop.cls.getAnnotation(TableAnnotation.class);
        if (ans == null) return;
        if (ans.TableName() == "") return;

        try {
            //获取修改和删除对象的原始值
            List<LinkedHashMap<String, Object>> oldValues = getOldEntity(mop.parameter, mop.invocation, ans);

            //获取字段的值
            Field[] fields = mop.cls.getDeclaredFields();
            String changedContent = "";
            for (Field field : fields) {
                //没有字段注解的属性不处理
                ColumnAnnotation clnAnn = field.getAnnotation(ColumnAnnotation.class);
                if (clnAnn == null) continue;

                String value = getFieldValue(mop.parameter, field, clnAnn);
                changedContent += clnAnn.FieldDescription() + "：" + value;
                if (oldValues != null && oldValues.size() > 0) {
                    changedContent += " 原值：" + oldValues.get(0).get(clnAnn.FieldName());
                }
                changedContent += "<br/>";
            }
            //保存日志
            CfDatachangedlog log = new CfDatachangedlog();
            log.setId(UUIDGenerator.getPrimaryKey());
            log.setChangedData(changedContent);
            log.setTableName(ans.TableName());
            log.setTableDesc(ans.TableDescription());
            //测试环境直接赋值
            UserInfo user = UserInfoUtil.getUserInfo();
            if (StringUilt.stringIsNullOrEmpty(user.getId())) {
                log.setOperatorName("admin");
                log.setOperatorId("123");
            } else {
                log.setOperatorName(user.getUserName());
                log.setOperatorId(user.getId());
            }

            log.setOperateDate(new Date());
            if (mop.mappedStatement.getSqlCommandType().compareTo(SqlCommandType.INSERT) == 0)
                log.setOperateType(DataChangedType.Add.ordinal());
            else if (mop.mappedStatement.getSqlCommandType().compareTo(SqlCommandType.DELETE) == 0)
                log.setOperateType(DataChangedType.Delete.ordinal());
            else if (mop.mappedStatement.getSqlCommandType().compareTo(SqlCommandType.UPDATE) == 0)
                log.setOperateType(DataChangedType.Edit.ordinal());
            log.setIp(DomainObjectUtil.getIpAddr());
            //取执行的SQL
            log.setExecutedSql(getSql(mop.configuration, mop.boundSql, mop.mappedStatement.getId()));

            dclMapper.insertSelective(log);
        }
        catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }

    /**
     * @param invocation
     * @description:根据拦截方法的不同，获取MappedStatement和BoundSql
     * @author:杨波
     * @date:2019-06-27
     * @parammop
     * @return:void
     **/
    private void getMybatisObject(Invocation invocation,
                                  MybatisObjectPack mop
    ) throws IllegalAccessException, ClassNotFoundException, InstantiationException {

        String methodName = invocation.getMethod().getName();

        mop.invocation = invocation;

        if (methodName.equals("prepare")) {
            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectHelpper.getFinalFieldValue(handler, "delegate");
            mop.boundSql = delegate.getBoundSql();
            mop.mappedStatement = (MappedStatement) ReflectHelpper.getFinalFieldValue(delegate, "mappedStatement");
        } else if (methodName.equals("update") || methodName.equals("query")) {
            mop.mappedStatement = (MappedStatement) invocation.getArgs()[0];
            if(invocation.getArgs()[1]!=null) {
                mop.parameter = invocation.getArgs()[1];
                mop.cls = mop.parameter.getClass();
            }
            mop.boundSql = mop.mappedStatement.getBoundSql(mop.parameter);
        }
        mop.configuration = mop.mappedStatement.getConfiguration();
        //如果按ID删除，要特殊处理
        if (mop.mappedStatement.getSqlCommandType().compareTo(SqlCommandType.DELETE) == 0) {
            getDeleteObject(mop);
        }
    }

    /**
     * @param mop
     * @description:获取删除对象的实体类
     * @author:杨波
     * @date:2019-06-27
     * @return:void
     **/
    private void getDeleteObject(MybatisObjectPack mop) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

//判断参数类型，参数类型是字符串，表示按ID在删除
        Class<?> paraType = mop.boundSql.getParameterMappings().get(0).getJavaType();
        if (paraType == String.class) {
            //获取SQL，将DELETE语句转换成SELECT语句，查询出要删除的数据
            String sql = showSql(mop.configuration, mop.boundSql);
            sql = sql.replace("delete ", "select * ");
            //获取要删除的记录
            SqlVo sqlVo = SqlVo.getInstance(sql);
            List<LinkedHashMap<String, Object>> deleteEntity = selectService.select(sqlVo);
            if (deleteEntity == null || deleteEntity.size() == 0) {
                //要删除的记录已经被其他人删除，直接退出
                return;
            }
            Map<String, Object> entity = deleteEntity.get(0);
            String entityJson = JSON.toJSONString(entity);

            //通过资源文件名获取删除实体类的名字
            String entityClassName = getDeleteClassName(mop.mappedStatement);
            //在当前包中查找该实体类
            Type type = PakageHelpper.getClassEndWithByName("com.hxoim", "entity." + entityClassName);
            //将查询到的当前删除记录的JSON数据转换成实体对象，并替换参娄对象
            mop.parameter = JSON.parseObject(entityJson, type);
            //获取删除对象的类，用于获取表注解
            mop.cls = mop.parameter.getClass();
        }
    }

    /**
     * @description: 获取删除和修改数据的原始值
     * @author:杨波
     * @date:2019-06-10 * @param parameter,invocation
     * @return:java.util.LinkedHashMap<java.lang.String,java.lang.Object>
     **/
    private List<LinkedHashMap<String, Object>> getOldEntity(Object parameter, Invocation invocation, TableAnnotation ans) throws NoSuchMethodException {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        if (mappedStatement.getSqlCommandType().compareTo(SqlCommandType.INSERT) == 0) return null;

        String where = ReflectHelpper.getPrimaryKeyWhere(parameter);

        String sql = "select * from " + ans.TableName() + " where 1=1 " + where;
        SqlVo sqlVo = SqlVo.getInstance(sql);
        List<LinkedHashMap<String, Object>> values = selectService.select(sqlVo);
        return values;
    }

    /**
     * @param field
     * @description:取字段的值，如果是字典或外键，先判断是否有属性来保存它的名称，有就取名称的值，然后判断是否设置了外键表，如果设置了外键关联的表、关联字段、关联表的名称字段，就取该名称字段的值
     * @author:杨波
     * @date:2019-06-10 * @param parameter 保存的实体类,field  要取值的字段,clnAnn 该属性的数据库字段注解
     * @return:java.lang.String
     **/
    private String getFieldValue(Object parameter, Field field, ColumnAnnotation clnAnn) {
        //取字段的值
        String value = "";
        try {
            Object fieldValue = ReflectHelpper.getFieldValue(parameter, field.getName());
            if (fieldValue != null)
                value = fieldValue.toString();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //如果该字段有关联的名称字段，采用名称字段的值
        if (clnAnn != null && StringUilt.stringIsNullOrEmpty(clnAnn.FieldDescriptionProperty()) == false) {
            try {
                Object fieldValue = ReflectHelpper.getFieldValue(parameter, clnAnn.FieldDescriptionProperty());
                if (fieldValue != null)
                    value = fieldValue.toString();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else if (clnAnn != null && StringUilt.stringIsNullOrEmpty(clnAnn.ForeignTable()) == false &&
                StringUilt.stringIsNullOrEmpty(clnAnn.ForeignColumn()) == false &&
                StringUilt.stringIsNullOrEmpty(clnAnn.ForeignDescriptionColumn()) == false) {
//设置了外键关联，通过外键关联表获取外键对应的名称值
            String where = " where " + clnAnn.ForeignColumn() + "='" + value + "'";

            String sql = "select " + clnAnn.ForeignDescriptionColumn() + " from " + clnAnn.ForeignTable() + where;
            SqlVo sqlVo = SqlVo.getInstance(sql);
            List<LinkedHashMap<String, Object>> values = selectService.select(sqlVo);
            if (values != null && values.size() > 0)
                value = values.get(0).get(clnAnn.ForeignDescriptionColumn()).toString();
        }
        return value;
    }

    // 封装了一下sql语句，使得结果返回完整xml路径下的sql语句节点id + sql语句
    public static String getSql(Configuration configuration, BoundSql boundSql, String sqlId) {
        String sql = showSql(configuration, boundSql);
        StringBuilder str = new StringBuilder(100);
        str.append(sqlId);
        str.append(":");
        str.append(sql);
        return str.toString();
    }

    //进行？的替换
    public static String showSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject(); // 获取参数
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " "); // sql语句中多个空格都用一个空格代替
        if (parameterMappings.isEmpty() == false && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry(); // 获取类型处理器注册器，类型处理器的功能是进行java类型和数据库类型的转换<br>　　　　　　　// 如果根据parameterObject.getClass(）可以找到对应的类型，则替换
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(parameterObject)));


            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);// MetaObject主要是封装了originalObject对象，提供了get和set的方法用于获取和设置originalObject的属性值,主要支持对JavaBean、Collection、Map三种类型对象的操作
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName); // 该分支是动态sql
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else {
                        sql = sql.replaceFirst("\\?", "缺失");
                    }//打印出缺失，提醒该参数缺失并防止错位
                }
            }
        }
        return sql;
    }

    /*如果参数是String，则添加单引号， 如果是日期，则转换为时间格式器并加单引号； 对参数是null和不是null的情况作了处理<br>　　*/
    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(new Date()) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }
        }
        return value;
    }

    /**
     * @description:从mapper配置文件名获取当前实体类的名字，用于删除时获取实体类实例
     * @author:杨波
     * @date:2019-06-24 * @param mappedStatement
     * @return:
     **/
    public static String getDeleteClassName(MappedStatement mappedStatement) {
        String resource = mappedStatement.getResource();
        String[] resourcePath = resource.split("/");
        String result = resourcePath[resourcePath.length - 1].replace("Mapper.xml", "");
        return result;
    }
}
