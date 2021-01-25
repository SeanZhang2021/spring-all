package org.sean.bean;

public class StudentFactory {
    public Student createStudent() {
        return new Student(3);
    }
}
