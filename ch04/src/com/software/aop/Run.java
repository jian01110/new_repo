package com.software.aop;

import com.software.d4.StudentStudy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Run {
    public static void main(String[] args) {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        FieldService fieldService = ctx.getBean("fieldservice", FieldService.class);
        Field field = new Field("1234","东头",50.00);
        fieldService.addFieldInfo(field);
    }
}
