package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easynotes.model.Student;
import com.example.easynotes.repository.StudentRepository;
@Service 
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student updateStudent(long id , Student student){
        if (student != null) {
            Student findStudent = studentRepository.getById(id);
            if (findStudent != null) {
                findStudent.setName(student.getName());
                findStudent.setAge(student.getAge());
                findStudent.setAddress(student.getAddress());

                return studentRepository.save(findStudent);
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
}
