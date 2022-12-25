package com.example.webflux.service;




import com.example.webflux.entity.Student;
import reactor.core.publisher.Flux;

import java.util.List;


public interface StudentService {

    void insertStudent(Student student);

    Student getStudentById(int id );

    List<Student> getAllStudents() throws InterruptedException;

   Student updateStudentById(Student student , int id);



   void deleteStudentById(int id);

    public Flux<Student> loadAllStudentsStream() throws InterruptedException;
}
