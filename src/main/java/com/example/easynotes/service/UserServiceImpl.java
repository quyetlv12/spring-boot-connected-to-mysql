package com.example.easynotes.service;

import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> signup(User user){
        // kiểm tra người dùng đã tồn tại trong hệ thống chưa
        if (userRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đăng kí thất bại , tài khoản đã được đăng kí !");
        }else{
            // Lưu dữ liệu vào db
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("Đăng kí thành công !");
        }
    }
}
