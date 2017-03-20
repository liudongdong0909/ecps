package com.ecps.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * controller层日志切面
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-16 下午 05:17
 */
/*@Aspect
@Component*/
public class ControllerLogAspect {

    private Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切入点
     */
    @Pointcut("execution(public  * com.ecps.controller..*.*(..))")
    public void controllerLog(){}

    /**
     *  前置通知
     * @param joinPoint
     */
    @Before("controllerLog()")
    public void before(JoinPoint joinPoint){

        // 当前线程记录请求开始时间
        startTime.set(System.currentTimeMillis());

        // 从thread local 线程中获取当前的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 记录请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "object", pointcut = "controllerLog()")
    public void after(Object object){

        //处理完成 返回内容
        logger.info("RESPONSE : " + object);

        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}
