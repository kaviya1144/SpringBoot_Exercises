package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;

    @PostMapping("/postEmployee")
    public ResponseEntity<Employee> post(@RequestBody Employee Employee) {

        try {
            Employee store = EmployeeService.postEmployee(Employee);
            return new ResponseEntity<>(store, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/putEmployee/{EmployeeId}")
    public ResponseEntity<Employee> put(@PathVariable int EmployeeId, @RequestBody Employee Employee) {
        Employee updatedEmployee = EmployeeService.putEmployee(EmployeeId, Employee);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<Boolean> delete(@PathVariable("employeeId") int employeeId) {
        boolean deleted = EmployeeService.deleteEmployee(employeeId);
        if (deleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}
