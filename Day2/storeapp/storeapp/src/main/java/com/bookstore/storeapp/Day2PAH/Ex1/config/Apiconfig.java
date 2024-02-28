package com.bookstore.storeapp.Day2PAH.Ex1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Apiconfig {
    @Value("${ap.studentName}")
    private String studentName;
    @Value("${ap.studentDept}")
    private String studentDept;

    public Apiconfig() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

}
