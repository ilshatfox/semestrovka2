package com.example.demo.asp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Aspect
@Component
public class MyAnnotAspect {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(com.example.demo.validator.MyAnnot)")
    public void myAnnotMethod(){
    }

    @Around("myAnnotMethod()")
    public Object arroundCallAt(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long workTime = System.currentTimeMillis() - start;
        logger.info("Method: " + joinPoint.getSignature());
        logger.info("Work time: " + workTime);
        return  res;
    }
}
