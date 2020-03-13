package com.test.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rensong.pu
 * @date 2020/3/13 16:42 星期五
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface AA {
}
