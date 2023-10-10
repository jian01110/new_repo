package com.software.demo4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: hugx
 * @Date: 2023-9-25 15:51
 */
public class UserServiceAround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 执行调用方法的，login()
        System.out.println("SpringAPI实现环绕通知方法调用前");
        Object proceed = methodInvocation.proceed();
        System.out.println("SpringAPI实现环绕通知方法调用后");
        return proceed;
    }
}
