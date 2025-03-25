package com.vsk.aopexample.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorHandlingAspect {

    // Pointcut corrected for proper syntax and execution logic
    @AfterThrowing(pointcut = "execution(* com.vsk.aopexample.services.BusinessService.processTask(..)) && args(taskName)", throwing = "error")
    public void handleError(String taskName, Exception error) {
        // Log the error message with additional context
        System.out.println("Error occurred while processing task: " + taskName);
        System.out.println("Error details: " + error.getMessage());

        // Additional error-handling logic
        logSummary(taskName, error);
        suggestFix(error);
    }

    private void logSummary(String taskName, Exception error) {
        // Simulate saving an error summary (could integrate logging frameworks or database here)
        System.out.println("Logging error summary for task: " + taskName);
        System.out.println("Error: " + error.getClass().getSimpleName() + " - " + error.getMessage());
    }

    private void suggestFix(Exception error) {
        // Provide corrective action tips
        System.out.println("Tip: Validate task inputs and check application configuration.");
    }
}
