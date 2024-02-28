package com.example.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job.model.JobModel;

public interface JobRepository extends JpaRepository<JobModel,Integer>{
    
}
