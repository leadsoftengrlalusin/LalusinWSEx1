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
public class SailorRestControllerAdvice {

    @Pointcut("execution(public * org.gcash.training.codes.controller.SailorRestController.*(..))")
    public void reservationMethods() {}

    @Before("reservationMethods()")
    public void before(JoinPoint jp) {
        System.out.println("SAILOR - Start: " + jp.getSignature());
    }

    @AfterReturning(pointcut = "reservationMethods()", returning = "result")
    public void after(JoinPoint jp, Object result) {
        System.out.println("SAILOR - Success: " + jp.getSignature());
    }

    @AfterThrowing(pointcut = "reservationMethods()", throwing = "ex")
    public void afterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("SAILOR - Exception in: " + jp.getSignature());
        ex.printStackTrace();
    }
}
