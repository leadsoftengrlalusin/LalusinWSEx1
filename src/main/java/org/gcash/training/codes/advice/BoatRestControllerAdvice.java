package org.gcash.training.codes.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoatRestControllerAdvice {

    @Pointcut("execution(* org.gcash.training.codes.controller.BoatRestController.*(..))")
    public void boatMethods() {}

    @Before("boatMethods()")
    public void before(JoinPoint jp) {
        System.out.println("BOAT - Start: " + jp.getSignature());
    }

    @AfterReturning(pointcut = "boatMethods()", returning = "result")
    public void after(JoinPoint jp, Object result) {
        System.out.println("BOAT - Success: " + jp.getSignature());
    }

    @AfterThrowing(pointcut = "boatMethods()", throwing = "ex")
    public void afterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("BOAT - Exception in: " + jp.getSignature());
        ex.printStackTrace();
    }
}
