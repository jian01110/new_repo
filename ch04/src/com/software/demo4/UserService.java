package com.software.demo4;

public interface UserService {
    public void login(String username, String password) throws Exception;
    public void register(String username, String password);
}
