package ru.mrchebik.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by mrchebik on 19.02.17.
 */
@Aspect
@Component
public class CountImpl0Aspect {
    @Pointcut("execution(* ru.mrchebik.bean.CountImpl0.getCount(..))")
    private void getCount(){}

    @Before("getCount()")
    public void logBeforeGetCount(JoinPoint joinPoint) {
        // "Log -- Method: " + joinPoint.getSignature().getName() + " // Execute: BEFORE"
    }

    @AfterReturning("getCount()")
    public void logAfterReturningGetCount(JoinPoint joinPoint) {
        // "Log -- Method: " + joinPoint.getSignature().getName() + " // Execute: AFTER RETURNING"
    }

    @Before("execution(* ru.mrchebik.bean.CountImpl0.setCount(..))")
    public Object settingBeforeSetCount(JoinPoint joinPoint) {
        // "Log -- Method: " + joinPoint.getSignature().getName() + " // Execute: BEFORE"
        Object[] args = joinPoint.getArgs();
        if ((Integer) args[0] == -1) {
            args[0] = 10;
            try {
                return ((ProceedingJoinPoint) joinPoint).proceed(args);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        return null;
    }

    @After("execution(* ru.mrchebik.bean.CountImpl0.getCount(..))")
    public void logAfterGetCount(JoinPoint joinPoint) {
        // "Log -- Method: " + joinPoint.getSignature().getName() + " // Execute: AFTER"
    }
}
