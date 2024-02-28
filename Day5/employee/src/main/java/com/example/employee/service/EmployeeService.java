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
    private EmployeeRepo EmployeeRepo;

    public Employee postEmployee(Employee Employee) {
        return EmployeeRepo.save(Employee);
    }

    public List<Employee> getEmployees() {
        return EmployeeRepo.findAll();
    }

    public Employee getEmployeeById(int EmployeeId) {
        return EmployeeRepo.findById(EmployeeId).orElse(null);
    }

    public Employee putEmployee(int EmployeeId, Employee Employee) {
        Optional<Employee> optionalEmployee = EmployeeRepo.findById(EmployeeId);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmployeeName(Employee.getEmployeeName());
            existingEmployee.setEmployeeEmail(Employee.getEmployeeEmail());
            existingEmployee.setSalary(Employee.getSalary());
            existingEmployee.setDepartment(Employee.getDepartment());
            return EmployeeRepo.save(existingEmployee);
        } else {
            return null;
        }
    }

    public boolean deleteEmployee(int id) {
        Optional<Employee> optionalEmployee = EmployeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
