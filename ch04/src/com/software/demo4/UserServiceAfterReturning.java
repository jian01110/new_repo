package com.software.demo4;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Author: hugx
 * @Date: 2023-9-25 15:48
 */
public class UserServiceAfterReturning implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("SpringAPI实现后置通知");
    }
}
