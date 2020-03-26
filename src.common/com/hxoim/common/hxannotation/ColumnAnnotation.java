package com.hxoim.common.hxannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @description:定义字段的注解
* @author:杨波
* @date:2019-06-05
**/
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnAnnotation {
    /**
    * @description:数据库字段名
    * @author:杨波
    * @date:2019-06-05
    * @param null:
    * @return:
    **/
    public String FieldName();
    /**
    * @description:字段中文名称
    * @author:杨波
    * @date:2019-06-05
    * @param null:
    * @return:
    **/
    public String FieldDescription();
    /**
    * @description:外键对应的表
    * @author:杨波
    * @date:2019-06-05
    * @param null:
    * @return:
    **/
    public String ForeignTable() default "";
    /**
    * @description:外键表对应的关联字段
    * @author:杨波
    * @date:2019-06-05
    * @param null:
    * @return:
    **/
    public String ForeignColumn() default "";
    /**
    * @description:外键表对应的名称字段
    * @author:杨波
    * @date:2019-06-05
    * @param null:
    * @return:
    **/
    public String ForeignDescriptionColumn() default "";
    /**
    * @description:如果该属性有值，就不再关联外键表取值，直接取对象该属性的值作为中文描述
    * @author:杨波
    * @date:2019-06-05
    * @param null:
    * @return:
    **/
    public String FieldDescriptionProperty() default "";
}
