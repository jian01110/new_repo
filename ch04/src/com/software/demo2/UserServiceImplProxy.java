package com.software.demo2;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:25
 */
public class UserServiceImplProxy implements UserService{

    private UserService userService;

    public UserServiceImplProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void login(String username, String password) {
        log();
        userService.login(username, password);
        loginTime();
    }

    @Override
    public void register(String username, String password) {
        log();
        userService.register(username, password);
        loginTime();
    }

    public void log() {
        System.out.println("记录日志");
    }

    public void loginTime() {
        System.out.println(System.currentTimeMillis());
    }
}
