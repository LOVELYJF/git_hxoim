package com.hxoim.common.hxannotation;/*
 * @description:标识该字段是否是主键
 * @author 杨波
 * @date:2019-06-05
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdAnnotation {
}
