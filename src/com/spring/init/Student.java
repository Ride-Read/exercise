package com.spring.init;

public class Student extends Person {
    public String studentName=null;

    public Student() {
        super();
        System.out.println("personName:   " + personName);
        System.out.println("studentName:   " + studentName);
    }

    public static void main(String[] args) {
        new Student();
    }
}
