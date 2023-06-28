package com.example.easynotes.service;

import java.util.List;

import com.example.easynotes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.easynotes.model.Student;
import com.example.easynotes.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public ResponseEntity<Object> addStudent(Student student){
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
    public ResponseEntity<String> updateStudent(long id , Student student){
        if (student != null) {
            Student findStudent = studentRepository.getById(id);
            if (findStudent != null) {
                findStudent.setName(student.getName());
                findStudent.setAge(student.getAge());
                findStudent.setAddress(student.getAddress());
                findStudent.setEmail(student.getEmail());
                studentRepository.save(findStudent);
                return ResponseEntity.status(HttpStatus.OK).body("Cập nhật thành công");
            }            
        }
        return null;
    };

    public boolean deleteStudent(long id){
        if (id >= 1) {
            Student student = studentRepository.getById(id);
            if (student != null) {
                studentRepository.delete(student);
                return true;
            }
        }
        return false;
    };


    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    };

    public Student getStudent(long id){
        return studentRepository.getById(id);
    };

    public ResponseEntity<String> ClearAllStudents(){
        studentRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Clear dữ liệu thành công");
    }

    public List filterStudent(String name){
        return studentRepository.findByName(name);
    }

}
