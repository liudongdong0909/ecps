package com.ecps.aop.log.ann;

import java.lang.annotation.*;

/**
 * 拦截service
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-16 下午 09:08
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysServiceLog {

    String description() default "";
}
