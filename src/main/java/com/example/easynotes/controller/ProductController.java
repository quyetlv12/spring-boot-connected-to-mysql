package com.example.easynotes.controller;

import com.example.easynotes.model.Product;
import com.example.easynotes.model.Student;
import com.example.easynotes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }


    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable("id") long id , @RequestBody Product product){
        return productService.editProduct(id , product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        return productService.detelteProduct(id);
    }
}
