package com.software.demo1;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:10
 */
public class StudentProxy implements SendFlower {
    private SendFlower student;

    public StudentProxy(SendFlower student) {
        this.student = student;
    }

    public void sendFlower(String receive) {
        sing();
        //System.out.println(student.getName() + "送花给：" + receive);
        this.student.sendFlower(receive);
    }

    public void sing() {
        System.out.println("唱着歌");
    }

    public SendFlower getStudent() {
        return student;
    }

    public void setStudent(SendFlower student) {
        this.student = student;
    }
}
