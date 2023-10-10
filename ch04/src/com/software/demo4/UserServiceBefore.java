package com.software.demo4;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: hugx
 * @Date: 2023-9-25 15:15
 */
public class UserServiceBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("SpringAPI实现的前置通知");
    }
}
