package com.software.d4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        StudentStudy studentStudy=ctx.getBean("student",StudentStudy.class);
        studentStudy.study("李四");
        studentStudy.eat();
    }
}
