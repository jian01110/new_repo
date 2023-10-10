package com.software.demo1;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:09
 */
public class Student implements SendFlower {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void sendFlower(String receive) {
        System.out.println(name + "给花给：" + receive);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
