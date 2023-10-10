package com.software.d4;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements StudentStudy{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void study(String name) {
        System.out.println(name+"正在学习");
    }
    public void eat(){
        System.out.println("正在吃饭");
    }
}
