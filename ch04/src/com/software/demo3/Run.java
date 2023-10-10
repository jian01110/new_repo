package com.software.demo3;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:46
 */
public class Run {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyUtil proxyUtil = new ProxyUtil();
        UserService proxy = (UserService) proxyUtil.createInstance(userService);
        proxy.login("hugx", "1234456");
    }
}
