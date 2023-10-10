package com.software.d4;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class StudyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("在这之前");
    }
}
