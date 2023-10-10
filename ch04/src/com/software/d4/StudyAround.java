package com.software.d4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class StudyAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("在这之前");
        Object proceed = methodInvocation.proceed();
        System.out.println("在这之后");
        return proceed;
    }
}
