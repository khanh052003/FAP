package org.example.service;

import org.example.entity.Teacher;
import org.example.interfaces.TeacherInterface;
import java.util.List;

public class TeacherServiceProxy implements TeacherInterface {
    // Real TeacherService instance
    private TeacherService realTeacherService;

    public TeacherServiceProxy() {
        // Lazy initialization of the real service
        this.realTeacherService = TeacherService.getInstance();
    }

    @Override
    public Teacher insert(Teacher s) {
        // You can add additional logic before or after calling the real service method
        System.out.println("Proxy: Inserting teacher " + s.getName());
        return realTeacherService.insert(s);
    }

    @Override
    public Teacher update(Teacher s) {
        // You can add additional logic before or after calling the real service method
        System.out.println("Proxy: Updating teacher");
        return realTeacherService.update(s);
    }

    @Override
    public boolean delete(int id) {
        // You can add additional logic before or after calling the real service method
        System.out.println("Proxy: Deleting teacher");
        return realTeacherService.delete(id);
    }

    @Override
    public List<Teacher> findAll() {
        // You can add additional logic before or after calling the real service method
        System.out.println("Proxy: Finding all teachers");
        return realTeacherService.findAll();
    }

    @Override
    public Teacher findById(int id) {
        // You can add additional logic before or after calling the real service method
        System.out.println("Proxy: Finding teacher by id");
        return realTeacherService.findById(id);
    }
}
