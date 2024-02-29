package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/api/customer")
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer) {
        try {
            Customer created = customerService.createUser(customer);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> li = customerService.getAllCustomers();

        if (li.isEmpty()) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/customer/{customerId}")
    public ResponseEntity<Customer> getById(@PathVariable int customerId) {
        Customer customer = customerService.getcustomerId(customerId);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/customer/bycity/{city}")
    public ResponseEntity<List<Customer>> getByName(@PathVariable("bycity") String city) {
        List<Customer> Userbycity = customerService.getByCity(city);
        if (Userbycity != null) {
            return new ResponseEntity<>(Userbycity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
