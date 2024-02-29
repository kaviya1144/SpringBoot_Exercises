package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    Course findByName(String courseName);

}