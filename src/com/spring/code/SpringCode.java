package com.spring.code;

import java.util.ArrayList;

public class SpringCode {

    public static User aaa() {
        User u = new User();
        try {

            u.setId(5);

            return u;
        } catch (Exception e) {

        } finally {
            u.setId(10);
        }
        return u;
    }

    public static void main(String[] args) {
        User u = new User();
        // u.setId(1);
        Integer i = null;
        User us = new User();
        // us.setId(1);
        System.out.println(us.getId() == i);
        ArrayList list=new ArrayList<>(999999999);
    }

}
