package com.study.config;

import com.google.common.collect.Maps;
import com.study.annotation.LimitNumber;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: zjt
 * @date: 2020-04-25 20:59
 */
@Component
@Aspect
public class LimitNumberAspect {

    private static final Map<String, Semaphore> LOCKCACHE = Maps.newConcurrentMap();


    @Pointcut("@annotation(com.study.annotation.LimitNumber)")
    public void LimitNumber() {

    }

    @Before("LimitNumber()")
    public void beforeLimitNumber(JoinPoint joinPoint) {
    }

    @Around("LimitNumber()")
    public Object aroundLimitNumber(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        LimitNumber limitNumber = methodSignature.getMethod().getAnnotation(LimitNumber.class);
        //限制并发数量
        proceedingJoinPoint.getSignature();

        String keyName = proceedingJoinPoint.getSignature().toLongString();
        Semaphore semaphore = null;
        boolean containsKey = LOCKCACHE.containsKey(keyName);
        if (containsKey) {
            semaphore = LOCKCACHE.get(keyName);
        } else {
            semaphore = new Semaphore(limitNumber.limitThreadNum());
            LOCKCACHE.put(keyName, semaphore);
        }

        int acquireNum = limitNumber.acquireNum();
        int queueLength = semaphore.getQueueLength();
        if (acquireNum > queueLength) {
            acquireNum = queueLength;
        }

        semaphore.acquire(acquireNum);
        Object proceed = proceedingJoinPoint.proceed();

        semaphore.release(acquireNum);
        return proceed;
    }
}