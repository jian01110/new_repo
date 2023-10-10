package com.software.demo2;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:28
 */
public class Run {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.login("hugx","2345");
        System.out.println("================================");
        UserService userServiceProxy =
                new UserServiceImplProxy(userService);
        userServiceProxy.login("hugx","123456");

    }
}
