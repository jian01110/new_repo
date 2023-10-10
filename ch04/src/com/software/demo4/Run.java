package com.software.demo4;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: hugx
 * @Date: 2023-9-25 15:26
 */
public class Run {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        UserService userProxy = ctx.getBean("userProxy", UserService.class);
        try {
            userProxy.login("hugx", "123456");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
