package com.hxoim.common.Reflector;
/*
 * @description:反射助手
 * @author 杨波
 * @date:2019-06-05
 */

import com.hxoim.common.hxannotation.IdAnnotation;
import com.hxoim.common.utils.StringUilt;
import com.hxoim.common.utils.UserInfoUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ReflectHelpper {
    /**
     * @param name
     * @description:获取对象属性的值
     * @author:杨波
     * @date:2019-06-05 * @param src
     * @return:java.lang.Object
     **/
    public static Object getFieldValue(Object src, String name)
            throws NoSuchMethodException {
        String methodname = "get" + StringUilt.toUpperCaseFirstOne(name);
        Object value = null;
        Class<? extends Object> clazz = src.getClass();

        Method method = clazz.getDeclaredMethod(methodname, new Class[]{}); // 获取定义的方法
        if (!Modifier.isPublic(method.getModifiers())) { // 设置非共有方法权限
            method.setAccessible(true);
        }
        try {
            value = method.invoke(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 利用反射获取指定对象的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标属性的值
     */
    public static Object getFinalFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 利用反射获取指定对象里面的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        return field;
    }

    /**
     * @description:获取表的主键列表
     * @author:杨波
     * @date:2019-06-05 * @param data
     * @return:java.util.List<java.lang.String>
     **/
    public static List<String> getPrimaryKeyFields(Object data) {
        List<String> ids = new ArrayList<>();
        Class<?> cls = data.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            IdAnnotation ann = field.getAnnotation(IdAnnotation.class);
            if (ann == null) continue;
            ids.add(field.getName());
        }
        return ids;
    }

    /**
     * @description:通过实体类的类名获取该类的主键字段列表（带有{@link IdAnnotation} 注解的视为主键），限于本包类
     * @author:杨波
     * @date:2019-06-10 * @param className
     * @return:java.util.List<java.lang.String>
     **/
    public static List<String> getPrimaryKeys(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        List<String> primaryKeys = new ArrayList<String>();
        Object classInstance = PakageHelpper.getClass("com.hxoim", className);
        primaryKeys = ReflectHelpper.getPrimaryKeyFields(classInstance);
        return primaryKeys;
    }

    /**
     * @description:获取对象的所有主键，然后根据主键的值拼接成where条件，最前面带and
     * @author:杨波
     * @date:2019-06-10 * @param data Object类型的实体类
     * @return:以and开头的where条件
     **/
    public static String getPrimaryKeyWhere(Object data) throws NoSuchMethodException {
        List<String> ids = getPrimaryKeyFields(data);
        String result = "";
        for (String id : ids) {
            result += " and " + id + "='" + getFieldValue(data, id) + "'";
        }
        return result;
    }

    /**
     * @param fname  属性名称
     * @param ftype  属性类型
     * @param fvalue 值
     * @description:给实体类的某个属性赋值
     * @author:杨波
     * @date:2019-07-03 * @param target 实体对象
     * @return:void
     **/
    @SuppressWarnings("unchecked")
    public static void setFieldValue(Object target, String fname,
                                     @SuppressWarnings("rawtypes") Class ftype, Object fvalue) {

        if (target == null || fname == null || "".equals(fname)) {
            return;
        }

        @SuppressWarnings("rawtypes")
        Class clazz = target.getClass();

        try {
            String methodname = "set" + Character.toUpperCase(fname.charAt(0))
                    + fname.substring(1);

            Method method = clazz.getDeclaredMethod(methodname, ftype); // 获取定义的方法
            if (!Modifier.isPublic(method.getModifiers())) { // 设置非共有方法权限
                method.setAccessible(true);
            }

            String typename = ftype.getName();
            if (typename.equals("java.lang.Integer")
                    || typename.endsWith("int")) {
                Integer value = Integer.valueOf(fvalue.toString());
                method.invoke(target, value);
            } else if (typename.equals("java.lang.Short")
                    || typename.endsWith("short")) {
                Short value = Short.valueOf(fvalue.toString());
                method.invoke(target, value);
            } else if (typename.toString().equals("java.lang.Long")
                    || typename.equals("long")) {
                Long value = Long.valueOf(fvalue.toString());
                method.invoke(target, value);
            } else if (typename.toString().equals("java.lang.Double")
                    || typename.equals("double")) {
                Double value = Double.valueOf(fvalue.toString());
                method.invoke(target, value);
            } else if (typename.toString().equals("java.lang.Boolean")
                    || typename.equals("boolean")) {
                Boolean value = Boolean.valueOf(fvalue.toString());
                method.invoke(target, value);
            } else {
                String className=fvalue.getClass().getName();
                if(className=="java.lang.String") {
                    method.invoke(target, fvalue); // 执行方法回调
                }
                else if(className=="java.util.Date")
                {
                    SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    method.invoke(target, f.format(fvalue));
                }
                    else
                {
                    method.invoke(target, fvalue.toString());
                }

            }
        } catch (Exception me) {// 如果set方法不存在，则直接设置类属性值

            try {
                Field field = clazz.getDeclaredField(fname); // 获取定义的类属性
                if (!Modifier.isPublic(field.getModifiers())) { // 设置非共有类属性权限
                    field.setAccessible(true);
                }
                field.set(target, fvalue); // 设置类属性值

            } catch (Exception fe) {
            }
        }
    }

    /**
     * @description:设置实体类修改字段的值，包括修改时间、修改人
     * @author:杨波
     * @date:2019-07-03 * @param object
     * @return:void
     **/
    public static void setModifyFields(Object object) {
        Field field = getField(object, "modifyTime");
        if (field != null) {
            setFieldValue(object, "modifyTime", field.getType(), new Date());
        }
        field = getField(object, "modifyUser");
        if (field != null) {
            setFieldValue(object, "modifyUser", field.getType(), UserInfoUtil.getUserInfo().getUserName());
        }
    }
}
