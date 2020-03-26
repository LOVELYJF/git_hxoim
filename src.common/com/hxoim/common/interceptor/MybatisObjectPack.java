package com.hxoim.common.interceptor;
/*
 * @description:根据不同拦截方法获取MappedStatement和BoundSql
 * @author 杨波
 * @date:2019-06-27
 */

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.Configuration;

public class MybatisObjectPack {
    public Invocation invocation;
    public MappedStatement mappedStatement;
    public BoundSql boundSql;
    public Configuration configuration;
    public Object parameter;
    public Class<?> cls;
}
