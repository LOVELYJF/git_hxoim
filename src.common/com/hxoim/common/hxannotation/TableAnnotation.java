package com.hxoim.common.hxannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @description:定义表的注解
* @author:杨波
* @date:2019-06-05
**/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableAnnotation {
    /**
    * @description:数据库表名
    * @author:杨波
    * @date:2019-06-05
    * @param null: 
    * @return:
    **/
    public String TableName();
    /**
    * @description:表的中文名称
    * @author:杨波
    * @date:2019-06-05
    * @param null: 
    * @return:
    **/
    public String TableDescription();
}
