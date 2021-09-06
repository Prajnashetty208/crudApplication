package com.springboot.crudapplication.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonLogger {

    Logger log = LoggerFactory.getLogger(CommonLogger.class);

    /*Execution under com.springboot.crudapplication
    any package .* any class .* any method .*
    any number of arguments (..)
     */
    @Pointcut(value = "execution(* com.springboot.crudapplication.*.*.*(..))")
    public void myPointCut(){
        //do nothing
    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().getName();
        log.info("Started method : ",method);
        Object o =pjp.proceed();
        log.info("Ending method : ",method);
        return o;
    }
}
