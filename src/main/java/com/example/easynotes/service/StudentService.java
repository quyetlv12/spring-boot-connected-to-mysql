package com.example.easynotes.service;

import java.util.List;

import com.example.easynotes.model.Student;

public interface StudentService {
    public Student addStudent(Student student);     

    public Student updateStudent(long id , Student student);

    public boolean deleteStudent(long id);

    public List<Student> getAllStudent();

    public Student getStudent(long id);
}
