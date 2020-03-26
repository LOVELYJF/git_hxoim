package com.hxoim.common.hxannotation;/*
 * @description:不记录包括该注解的日志，只是单纯通过长度来判断是否发生改变
 * @author 杨波
 * @date:2019-06-05
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreLogAnnotation {
}
