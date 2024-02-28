package com.example.productputdelt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productputdelt.model.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
}