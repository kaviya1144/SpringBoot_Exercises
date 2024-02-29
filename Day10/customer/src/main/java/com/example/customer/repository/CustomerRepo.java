package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.customer.model.Customer;
import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{
    
    @Query("Select s from Customer s where s.city=:city")
    List<Customer> findByCity(String city);
}
