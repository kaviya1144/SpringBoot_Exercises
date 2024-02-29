package com.example.studentpagesort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.studentpagesort.model.Student;
import com.example.studentpagesort.service.StudentService;

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/student")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
    }

    @GetMapping("/api/student")
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/student/sort/{offset}/{pageSize}/{field}")
    public ResponseEntity<List<Student>> getPageSort(@PathVariable ("offset") int offset,@PathVariable ("pageSize") int pageSize,@PathVariable("field") String field) {
        List<Student> li = studentService.childPaginationSort(offset, pageSize, field);
        
        if(li.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(li,HttpStatus.OK);
    }
}
