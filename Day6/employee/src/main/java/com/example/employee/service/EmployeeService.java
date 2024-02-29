package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee postEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getEmployeess() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeRepo.findById(employeeId).orElse(null);
    }

    public Employee putEmployee(int employeeId, Employee employee) {
        Optional<Employee> obj = employeeRepo.findById(employeeId);
        if (obj.isPresent()) {
            Employee updated = obj.get();
            updated.setEmployeeId(employee.getEmployeeId());
            updated.setProductName(employee.getProductName());
            updated.setDescription(product.getDescription());

            return productRepo.save(updated);
        } else {
            return null;
        }
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
