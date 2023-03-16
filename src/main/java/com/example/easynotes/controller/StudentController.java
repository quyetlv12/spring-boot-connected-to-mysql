package com.example.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.Student;
import com.example.easynotes.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentServices;

    @GetMapping
    public String test() {
        return "hello";
    }

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        return studentServices.addStudent(student);
    }

    @PutMapping("/edit-student")
    public Student editStudent(@RequestParam("id") long id, @RequestBody Student student) {
        return studentServices.updateStudent(id, student);
    }


    @DeleteMapping("/delete-student/{id}")
    public boolean deleteStudent(@PathVariable("id") long id){
        return studentServices.deleteStudent(id);
    }

    @GetMapping("/students")
    public List<Student> getAll(){
        return studentServices.getAllStudent();
    }
}
