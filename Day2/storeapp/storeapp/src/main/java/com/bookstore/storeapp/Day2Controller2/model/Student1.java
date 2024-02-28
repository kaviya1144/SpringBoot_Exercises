package com.bookstore.storeapp.Day2Controller2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student1 {
    @JsonProperty("My Name ")
    private String name;
    @JsonProperty("My Age")
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
