package com.vsk.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.vsk.aopexample.services..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Entering method: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        System.out.println("Exiting method: " + joinPoint.getSignature());
        return result;
    }
}