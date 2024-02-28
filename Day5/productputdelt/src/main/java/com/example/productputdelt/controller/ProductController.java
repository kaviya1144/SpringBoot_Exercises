package com.example.productputdelt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.productputdelt.model.Product;
import com.example.productputdelt.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/postProduct")
    public ResponseEntity<Product> post(@RequestBody Product product) {

        try {
            Product store = productService.postProduct(product);
            return new ResponseEntity<>(store, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/putproduct/{productId}")
    public ResponseEntity<Product> put(@PathVariable int productId, @RequestBody Product product) {
        Product updatedProduct = productService.putProduct(productId, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    @DeleteMapping("/deleteproduct/{productId}")
    public ResponseEntity<Product> delete(@PathVariable("productId") int productId) {
        Product deletedProduct = productService.deleteProduct(productId);
        if (deletedProduct != null) {
            return ResponseEntity.ok(deletedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
