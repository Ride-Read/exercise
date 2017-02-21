package com.spring.init;

public class InitCode {
     static void InitCoder(final Person person) {
        if (person instanceof Student) {
            Student student = (Student) person;
            student.studentName = "studentName";
        }
        person.personName = "personName";
    }
}
