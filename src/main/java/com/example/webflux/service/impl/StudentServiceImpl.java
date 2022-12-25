package com.example.webflux.service.impl;


import com.example.webflux.entity.Student;
import com.example.webflux.repo.StudentRepo;
import com.example.webflux.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    private static void sleepExecution(int i){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student getStudentById(int id) {

        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Student> getAllStudents() throws InterruptedException {
        long start = System.currentTimeMillis();
                Thread.sleep(5000);
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudentById(Student student, int id) {
        Student studentFromDb  = studentRepo.findById(id).get();

        studentFromDb.setName(student.getName());
        studentFromDb.setAge(student.getAge());
        studentFromDb.setAddress(student.getAddress());
        studentFromDb.setFatherName(student.getFatherName());
        return studentRepo.save(studentFromDb);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteById(id);

    }

    public Flux<Student> loadAllStudentsStream() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        Flux<Student> students = Flux.fromIterable(studentRepo.findAll());
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return students;
    }
}
