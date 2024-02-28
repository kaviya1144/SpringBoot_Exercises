package com.example.springjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentDetails {

    @Id
    private int rollNo;
    private String name;
    private String dept;
    
    // public StudentDetails(int rollNo, String name, String dept) {
    //     this.rollNo = rollNo;
    //     this.name = name;
    //     this.dept = dept;
    // }
    
    public StudentDetails() {
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    
    
}
