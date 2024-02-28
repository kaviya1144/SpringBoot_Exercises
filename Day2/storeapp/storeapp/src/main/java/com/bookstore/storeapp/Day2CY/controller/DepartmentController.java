package com.bookstore.storeapp.Day2CY.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bookstore.storeapp.Day2CY.model.Department;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DepartmentController {
    
    @GetMapping("/depart")
    public Department getValues() {
        Department dep = new Department("CSE", "BTECH");
        return dep;
    }
    
}
