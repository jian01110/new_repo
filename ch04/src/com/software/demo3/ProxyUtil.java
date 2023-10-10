package com.software.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:35
 * 不管是静态代理，还是动态代理，必须要知道代理谁？
 * 不管是静态代理，还是动态代理，一定要生成一个代理的对象。
 */
public class ProxyUtil implements InvocationHandler {

    Object target;

    // 是一个创建代理对象的方法
    // 相当于new UserServiceImplProxy(XXX XXX)
    public Object createInstance(Object target) {
        this.target = target;
        // 动态代理，是通过什么方式创建的对象？反射
        ClassLoader classLoader = this.target.getClass().getClassLoader();
        Class<?>[] interfaces = this.target.getClass().getInterfaces();
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用哪一个，执行哪一个 login
        log();
        Object invoke = method.invoke(target, args);
        loginTime();
        return invoke;
    }
    public void log() {
        System.out.println("记录日志");
    }

    public void loginTime() {
        System.out.println(System.currentTimeMillis());
    }
}
