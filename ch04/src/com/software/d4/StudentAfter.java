package com.software.d4;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class StudentAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("在这之后");
    }
}
