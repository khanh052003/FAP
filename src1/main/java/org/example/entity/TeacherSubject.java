package org.example.entity;

import org.example.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class TeacherSubject {
    private List<Observer> observers = new ArrayList<>();
    private String teacherName;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        notifyObservers("Teacher's name has been updated to: " + teacherName);
    }
}