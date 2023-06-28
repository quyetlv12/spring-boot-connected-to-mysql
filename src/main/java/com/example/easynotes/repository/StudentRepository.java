package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Student;

import java.util.List;

@Repository
public interface  StudentRepository extends JpaRepository<Student , Long> {
    List findByName(String name);
}
