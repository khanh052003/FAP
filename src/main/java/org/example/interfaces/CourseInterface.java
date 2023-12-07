// CourseInterface.java
package org.example.interfaces;

import org.example.entity.Course;

import java.util.List;

public interface CourseInterface {
    Course insert(Course course);
    Course update(Course course);
    boolean delete(int id);
    boolean deleteByTeacherID(int id);
    List<Course> findAll();
    Course findById(int id);
    List<Course> findByName(String name);
}
