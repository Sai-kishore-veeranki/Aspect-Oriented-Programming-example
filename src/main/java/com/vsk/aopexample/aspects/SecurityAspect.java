package com.vsk.aopexample.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.vsk.aopexample.services.BusinessService.processTask(..)) && args(taskName)")
    public void checkAuthorization(String taskName) {
        System.out.println("Performing security check for task: " + taskName);
        if (taskName.toLowerCase().contains("sensitive")) {
            throw new SecurityException("Unauthorized access to sensitive task");
        }

        System.out.println("Security check passed for task: " + taskName);
    }
}

