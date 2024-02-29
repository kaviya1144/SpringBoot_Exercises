package com.example.productpagesort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.productpagesort.model.Product;
import com.example.productpagesort.service.ProductService;

public class ProductController {
    
    @Autowired
    private ProductService productService;
    @PostMapping("/api/children")
    public ResponseEntity<Product> createPatient(@RequestBody Product product) {
        try {
            Product created = productService.create(product);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/product/{offset}/{pageSize}")
    public ResponseEntity<List<Product>> getPage(@PathVariable ("offset") int offset,@PathVariable ("pageSize") int pageSize) {
        Page<Product> page = productService.childPagination(offset, pageSize);
        List<Product> li = page.getContent();
        
        if(li.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(li,HttpStatus.OK);
    }

    @GetMapping("/api/product/{offset}/{pageSize}/{field}")
    public ResponseEntity<List<Product>> getPageSort(@PathVariable ("offset") int offset,@PathVariable ("pageSize") int pageSize,@PathVariable("field") String field) {
        List<Product> li = productService.childPaginationSort(offset, pageSize, field);
        
        if(li.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(li,HttpStatus.OK);
    }

    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId) {
        Product product = productService.getId(productId);
        
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
