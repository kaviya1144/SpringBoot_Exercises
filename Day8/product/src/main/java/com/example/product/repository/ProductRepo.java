package com.example.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.product.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("Select distinct p from Product p where p.productName LIKE CONCAT(:value, '%')")
    List<Product> findByStartWithName(@Param("value") String value);

    @Query("Select distinct p from Product p where p.productName LIKE CONCAT('%', :value)")
    List<Product> findByEndWithName(@Param("value") String value);


}
