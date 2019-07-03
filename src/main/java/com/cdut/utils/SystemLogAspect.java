package com.cdut.utils;

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
import java.util.Enumeration;

/**
 * 项目级日志处理方法
 */
@Component
@Aspect
public class SystemLogAspect {
    private final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * 所有controller方法的切点
     */
    @Pointcut("execution(public * com.cdut.controller.*.*(..))")
    public void controllerAspect(){

    }

    /**
     * 所有service方法的切入点
     */
    @Pointcut("execution(public * com.cdut.service.*.*(..))")
    public void serviceAspect(){

    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("执行方法  :"+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName());
        logger.info("HTTP_METHOD : " + request.getMethod());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:{},value:{}", name, request.getParameter(name));
        }


    }

    @AfterThrowing(pointcut = "controllerAspect()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable)  {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        // 获取用户请求方法的参数并序列化为JSON格式字符串
        StringBuffer params = new StringBuffer();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            params.append("{");
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params.append(joinPoint.getArgs()[i]);
                params.append(",");
            }
            params.deleteCharAt(params.length()-1);
            params.append("}");
        }
        StringBuffer paramNames = new StringBuffer();
        paramNames.append("{");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            paramNames.append(parameterNames.nextElement());

        }
        paramNames.append("}");
        logger.info("=======================「START」执行出现异常「START」=====================================");
        String targetMethod = joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName();
        logger.error("异常方法为："+targetMethod);
        logger.error("HTTP_METHOD："+request.getMethod());
        logger.error("参数："+paramNames+"  值："+params);
        logger.error(throwable.toString());
        logger.info("=======================「END」执行出现异常「END」===============================");
    }



}
