package com.hxoim.general.select.entity;
/*
 * @description:用于往通用sql执行中传递sql语句
 * @author 杨波
 * @date:2019-06-12
 */

public class SqlVo {
    private String sql;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public static SqlVo getInstance(String sql) {
        /**
        * @description:获取sql语句封装类的实例
        * @author:杨波
        * @date:2019-06-12
        *  * @param sql 要执行的SQL
        * @return:com.hxoim.common.SQLMapper.SqlVo
        **/
        SqlVo sqlVo = new SqlVo();
        sqlVo.setSql(sql);
        return sqlVo;
    }
}
