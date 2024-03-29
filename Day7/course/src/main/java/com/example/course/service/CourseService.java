package com.example.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.course.model.Course;
import com.example.course.repository.CourseRepo;

@Service
public class CourseService {
    private CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course create(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> listofDetails() {
        return courseRepo.findAll();
    }

    public Course getName(String courseName) {
        return courseRepo.findByName(courseName);
    }

}