package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Product;
import com.example.product.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {
    @Autowired
    private final ProductService ps;
    public ProductController(ProductService ps) {
        this.ps = ps;
    }
    @PostMapping("/api/product/add")
    public ResponseEntity<Product> create(@RequestBody Product obj)
    {
        return new ResponseEntity<>(ps.create(obj),HttpStatus.CREATED);
    }
    @GetMapping("/api/product")
    public ResponseEntity<List<Product>> getAll()
    {
        return new ResponseEntity<>(ps.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getById(@PathVariable int productId)
    {
        Product obj = ps.getById(productId);
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
}