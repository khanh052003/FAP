package org.example;

import org.example.entity.*;
import org.example.interfaces.NotifyInterface;
import org.example.interfaces.Observer;
import org.example.interfaces.UpdateInfoRequest;
import org.example.service.AccountFactory;
import org.example.service.AdminService;
import org.example.service.CourseService;
import org.example.service.FacadeService;
import org.example.service.TeacherService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Insert teacher =========Singleton - Đảm bảo rằng một lớp chỉ có một thể hiện
        //                                      và cung cấp một điểm truy cập toàn cục đến thể hiện đó.
        Teacher teacher = new Teacher(1, "Dinh Van Dong");
        Teacher teacher2 = new Teacher(2, "Ngo Thi Mai Loan");
        TeacherService.getInstance().insert(teacher);
        TeacherService.getInstance().insert(teacher2);
        // Iterator ============Behavior Cung cấp cách truy cập tuần tự đến các phần tử của
        //                                  một đối tượng mà không tiết lộ cấu trúc nội bộ của nó.


        CourseService courseService = CourseService.getInstance();
        Course course = new Course(1, "CS101", "CS", "Introduction to Computer Science", new Date(), new Date(), teacher, new ArrayList<>());
        Course course2 = new Course(2, "CS102", "CS", "SDLC", new Date(), new Date(), teacher2, new ArrayList<>());
        courseService.insert(course);
        courseService.insert(course2);
// Abstract Factory Pattern: =========Cung cấp một giao diện để tạo ra các họ đối tượng
        //                              liên quan hoặc phụ thuộc mà không cần chỉ định các lớp cụ thể.

        System.out.println("Course: " + course.getName() + ", Teacher: " + course.getTeacher().getName());
        System.out.println("Course2: " + course2.getName() + ", Teacher: " + course2.getTeacher().getName());
//Abstract Factory Pattern: Cung cấp một giao diện để tạo ra các họ đối tượng liên quan
//                          hoặc phụ thuộc mà không cần chỉ định các lớp cụ thể.
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "An"));
        studentList.add(new Student(2, "Binh"));
        studentList.add(new Student(3, "Nam"));

        // Đăng ký sinh viên vào khóa học
        courseService.enrollStudents(course.getId(), studentList);

        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.toString());
        }

        //===================================================================================
        // Adapter ========Structural Pattern
        UpdateInfoRequest updateInfoRequest = new AdminService(TeacherService.getInstance());
        updateInfoRequest.updateInfoTeacher(teacher);

        //===================================================================================
        // Factory Method == Creational Pattern
        NotifyInterface notifyStudent = AccountFactory.createNotification("Student");
        notifyStudent.notification();

        NotifyInterface notifyTeacher = AccountFactory.createNotification("Teacher");
        notifyTeacher.notification();

        NotifyInterface notifyParent = AccountFactory.createNotification("Parent");
        notifyParent.notification();
        //=========================================================================

        // Facade == Structural Pattern
        FacadeService facadeService = new FacadeService();
        facadeService.operationDeleteTeacher(1);

        TeacherSubject teacherSubject = new TeacherSubject();

        // Create student observers
        Observer student1 = new StudentObserver("Alice");
        Observer student2 = new StudentObserver("Bob");

        // Add student observers to the teacher subject
        teacherSubject.addObserver(student1);
        teacherSubject.addObserver(student2);

        // Set the teacher's name, which triggers an update to the observers
        teacherSubject.setTeacherName("Mr. Smith");



    }


}
