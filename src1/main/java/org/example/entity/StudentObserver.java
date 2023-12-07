package org.example.entity;

import org.example.interfaces.Observer;

public class StudentObserver implements Observer {
    private String studentName;

    public StudentObserver(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + studentName + " received an update: " + message);
    }
}