package com.example.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.example.easynotes.model.Student;
import com.example.easynotes.service.StudentService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentServices;

    @PostMapping("/add-student")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        return  studentServices.addStudent(student);
    }

    @PutMapping("/student/edit/{id}")
    public ResponseEntity<String> editStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return studentServices.updateStudent(id, student);
    }

    @DeleteMapping("/delete-student/{id}")
    public boolean deleteStudent(@PathVariable("id") long id) {
        return studentServices.deleteStudent(id);
    }

    @GetMapping("/students")
    public List<Student> getAll() {

        return studentServices.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getOneStudent(@PathVariable("id") long id) {
        return studentServices.getStudent(id);
    }
    @PostMapping("/student/clear")
    public ResponseEntity<String> clearStudents(){
        return studentServices.ClearAllStudents();
    }

    @GetMapping("/student-filter")
    public List filterStudentByName(@RequestParam(value = "name" , required = false) String name){
        return studentServices.filterStudent(name);
    }

}
