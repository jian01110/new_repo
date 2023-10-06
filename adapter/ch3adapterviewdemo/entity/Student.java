package net.onest.ch3adapterviewdemo.entity;

public class Student {
    private String name;
    private int num;

    public Student(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

    //定义属性
//    private int header;//头像
//    private String name;//姓名
//    private String no;//学号
//
//    public Student() {
//    }
//
//    public Student(int header, String name, String no) {
//        this.header = header;
//        this.name = name;
//        this.no = no;
//    }
//
//    public int getHeader() {
//        return header;
//    }
//
//    public void setHeader(int header) {
//        this.header = header;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNo() {
//        return no;
//    }
//
//    public void setNo(String no) {
//        this.no = no;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "header=" + header +
//                ", name='" + name + '\'' +
//                ", no='" + no + '\'' +
//                '}';
//    }

