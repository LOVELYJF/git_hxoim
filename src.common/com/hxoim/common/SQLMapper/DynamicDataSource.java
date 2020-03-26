package com.hxoim.common.SQLMapper;
/*
 * @description:实现多数据源动态切换
 * @author 杨波
 * @date:2019-07-17
 */

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    public static final String  centerDataSource= "centerDataSource";
    public static final String predbDataSource = "predbDataSource";
    //本地线程，获取当前正在执行的currentThread
    public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setCustomerType(String customerType) {

        contextHolder.set(customerType);

    }

    public static String getCustomerType() {
        return contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getCustomerType();
    }
}
