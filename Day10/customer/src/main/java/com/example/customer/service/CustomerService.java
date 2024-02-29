package com.example.customer.service;

import java.util.List;
import java.util.Optional;

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

    public Customer updateCustomerPincode(int customerId, int pincode) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setPincode(pincode);
            return customerRepo.save(customer);
        }
        return null;
    }

    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer deleted successfully.";
        }
        return "Customer not found.";
    }
}
