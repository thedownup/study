package com.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 限制并发的数量
 * @author: zjt
 * @date: 2020-04-25 20:58
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitNumber {

    int limitThreadNum() default 5;

    int acquireNum() default 1;

}
