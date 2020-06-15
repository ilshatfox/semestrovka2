package com.example.demo.asp;


import com.example.demo.models.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Aspect
@Component
public class MyAspect {
    private Logger logger = (Logger) LoggerFactory.getLogger("guru.springframework.helpers");

    @Pointcut("execution(public * com.example.demo.dto.UserDaoImpl.*(..))")
    public void pointcut1(){}

    @Before("pointcut1()")
    public void beforeCallService(JoinPoint joinPoint){
        logger.info("Method: " + joinPoint.getSignature());
    }

    @After("pointcut1()")
    public void afterCallService(JoinPoint joinPoint){
        logger.info("After Method: " + joinPoint.getSignature());
    }

    @AfterThrowing(pointcut = "execution(public * com.example.demo.dto.UserDaoImpl.saveUser(..))", throwing = "ex")
    public void afterThrowingExc(Throwable ex) throws Throwable{
        System.out.println(ex);
        logger.error("new_error! " + ex.toString());
    }

}
