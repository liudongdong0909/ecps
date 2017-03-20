package com.ecps.aop.log.ann;

import java.lang.annotation.*;

/**
 * 拦截controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-16 下午 09:05
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysControllerLog {

    String description() default  "";
}
