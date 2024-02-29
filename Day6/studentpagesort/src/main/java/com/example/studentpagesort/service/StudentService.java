package com.example.studentpagesort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.studentpagesort.model.Student;
import com.example.studentpagesort.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student create(Student student)
    {
        return studentRepo.save(student);
    }
    public List<Student> getAll()
    {
        return studentRepo.findAll();
    }

    public List<Student> childPaginationSort(int offset,int pageSize,String field){
        PageRequest pageRequest = PageRequest.of(offset, pageSize,Sort.Direction.ASC,field);
        Page<Student> page = studentRepo.findAll(pageRequest);
        return page.getContent();
    }
}
