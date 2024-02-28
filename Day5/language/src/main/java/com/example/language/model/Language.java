package com.example.language.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Language {

    @Id
    private int languageId;
    private String languageName;
    private String languageEmail;
    private double salary;
    private int department;

    public Language() {
    }

    public int getlanguageId() {
        return languageId;
    }

    public void setlanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getlanguageName() {
        return languageName;
    }

    public void setlanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getlanguageEmail() {
        return languageEmail;
    }

    public void setlanguageEmail(String languageEmail) {
        this.languageEmail = languageEmail;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

}
