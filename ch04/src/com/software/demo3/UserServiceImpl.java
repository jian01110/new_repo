package com.software.demo3;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:22
 */
public class UserServiceImpl implements UserService {
    @Override
    public void login(String username, String password) {
        System.out.println(username +  "登录成功");
    }

    @Override
    public void register(String username, String password) {
        System.out.println(username + "注册成功");
    }
}
