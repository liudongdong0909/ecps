package com.ecps.aop.log.aspect;


import com.ecps.aop.log.ann.SysControllerLog;
import com.ecps.aop.log.ann.SysServiceLog;
import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 切面类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-16 下午 09:10
 */
@Aspect
@Component
public class SysAspectLog {

    private Logger logger = LoggerFactory.getLogger(SysAspectLog.class);

    /**
     * 定义service层的切入点 基于注解的表达式
     */
    @Pointcut("@annotation(com.ecps.aop.log.ann.SysServiceLog)")
    public void serviceAspect() {
    }

    /**
     * 定义controller层的切入点 基于注解的表达式
     */
    @Pointcut("@annotation(com.ecps.aop.log.ann.SysControllerLog)")
    public void controllerAspect() {
    }

    /**
     * controller 层前置通知
     *
     * @param joinpoint
     */
    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) {
        // 当前线程中获取request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 获取请求的ip
        String ip = request.getRemoteAddr();

        try {
            System.out.println("===========前置通知开始=================");

            Object target = joinPoint.getTarget();
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + this.getControllerMethodDescription(joinPoint));
            System.out.println("请求人:" + "冬瓜 TODO 从当前线程中获取");
            System.out.println("请求IP:" + ip);

            // TODO
            // 入库

            System.out.println("===========前置通知结束=================");
        } catch (Exception e) {
            //记录本地异常日志
            logger.error("==============前置通知异常===============");
            logger.error("异常信息 : {}", e);
        }
    }

    /**
     * 获取controller注解中方法的描述
     *
     * @param joinPoint
     * @return
     */
    private String getControllerMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        Class<?> clazz = Class.forName(targetName);
        Method[] methods = clazz.getMethods();

        String description = "";

        if (ArrayUtils.isEmpty(methods)) {
            return null;
        }
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] classes = method.getParameterTypes();
                if (classes.length == args.length) {
                    description = method.getAnnotation(SysControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }


    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void after(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String ip = request.getRemoteAddr();

        //获取用户请求方法的参数 并拼接成字符串
        String params = "";

        if (ArrayUtils.isNotEmpty(joinPoint.getArgs())) {
            for (Object arg : joinPoint.getArgs()) {
                params += arg + ",";
            }
        }

        try {

            System.out.println("===========异常通知开始=================");

            System.out.println("异常代码: " + e.getClass().getName());
            System.out.println("异常信息：" + e.getMessage());
            System.out.println("异常方法：" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("请求参数：" + params);
            System.out.println("方法描述:" + this.getServiceMethodDescription(joinPoint));
            System.out.println("请求人:" + "冬瓜 TODO 从当前线程中获取");
            System.out.println("请求IP:" + ip);

            // TODO
            // 入库

            System.out.println("===========异常通知结束=================");


        } catch (Exception ex) {
            //记录本地日志
            logger.error("===== 异常通知 异常 =====");
            logger.error("异常信息 : {}", ex);
        }
        //记录本地异常信息
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);
    }

    /**
     * 获取service注解中的方法描述
     *
     * @param joinPoint
     * @return
     */
    private String getServiceMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {

        String targeName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Class<?> clazz = Class.forName(targeName);
        Method[] methods = clazz.getMethods();
        String description = "";
        if (ArrayUtils.isEmpty(methods)) {
            return null;
        }
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == args.length) {
                    description += method.getAnnotation(SysServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
