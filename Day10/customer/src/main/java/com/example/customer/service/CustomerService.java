package com.example.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer createUser(Customer customer) {
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getcustomerId(int customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    public List<Customer> getByCity(String city) {
        return customerRepo.findByCity(city);
    }
}
