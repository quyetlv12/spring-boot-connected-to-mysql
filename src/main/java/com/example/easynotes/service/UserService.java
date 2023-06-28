package com.example.easynotes.service;

import com.example.easynotes.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<String> signup(User user);
}
