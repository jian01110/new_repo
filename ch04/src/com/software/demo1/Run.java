package com.software.demo1;

/**
 * @Author: hugx
 * @Date: 2023-9-25 14:17
 */
public class Run {
    public static void main(String[] args) {
        // 实例化真实的对象
        // 名字随意起的，如有雷同，纯属巧合
        SendFlower student = new Student("张三");
        // 实例化代理对象
        SendFlower proxy = new StudentProxy(student);
        proxy.sendFlower("李芳");

    }
}
