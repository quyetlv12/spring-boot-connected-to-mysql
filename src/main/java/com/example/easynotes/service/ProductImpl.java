package com.example.easynotes.service;

import com.example.easynotes.model.Product;
import com.example.easynotes.model.Student;
import com.example.easynotes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public ResponseEntity<String> detelteProduct(long id) {
        if (id >= 1){
            Product findProduct = productRepository.getById(id);
            if (findProduct != null){
                productRepository.delete(findProduct);
                return ResponseEntity.status(HttpStatus.OK).body("Xoá sản phẩm thành công");
            }
        }
        return null;
    }

    public Product editProduct(long id, Product product) {
        if (product != null) {
            Product findProduct = productRepository.getById(id);
            if (findProduct != null) {
                findProduct.setName(product.getName());
                findProduct.setPrice(product.getPrice());
                findProduct.setDescription(product.getDescription());
                return  productRepository.save(findProduct);
            }
        }
        return null;
    }
}
