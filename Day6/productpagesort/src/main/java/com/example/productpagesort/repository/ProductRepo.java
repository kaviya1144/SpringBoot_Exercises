package com.example.productpagesort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productpagesort.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    
}
