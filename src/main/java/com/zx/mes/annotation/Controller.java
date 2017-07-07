package com.zx.mes.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/7/6.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {
    String value() default "";
}
