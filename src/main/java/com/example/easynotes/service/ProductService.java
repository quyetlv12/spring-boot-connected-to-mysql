package com.example.easynotes.service;

import com.example.easynotes.model.Product;
import com.example.easynotes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
 public List<Product> getAllProducts();

 public Product createProduct(Product product);

 public ResponseEntity<String> detelteProduct(long id);

 public Product editProduct(long id , Product product);
}
