package com.example.easynotes.service;

import java.util.List;

import com.example.easynotes.model.Student;
import com.example.easynotes.model.User;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    public ResponseEntity<Object> addStudent(Student student);

    public ResponseEntity<String> updateStudent(long id , Student student);

    public boolean deleteStudent(long id);

    public List<Student> getAllStudent();

    public Student getStudent(long id);

    public ResponseEntity<String> ClearAllStudents();

    public List<String> filterStudent(String name);
}
