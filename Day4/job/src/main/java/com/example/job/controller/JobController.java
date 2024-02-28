package com.example.job.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.job.model.JobModel;
import com.example.job.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class JobController {


    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @PostMapping("/api/job")
    public ResponseEntity<JobModel>createJob(@RequestBody JobModel job){
        JobModel createdJob=jobService.createJob(job);
        return new ResponseEntity<>(createdJob,HttpStatus.CREATED);
    }
    @GetMapping("/api/job")
    public ResponseEntity<List<JobModel>>getAllJob(){
        List<JobModel>job=jobService.getAllJobs();
        return new ResponseEntity<>(job,HttpStatus.OK);
    } 
    @GetMapping("/api/job/{jobId}")
    public ResponseEntity<JobModel>getById(@PathVariable int jobId){
        JobModel job=jobService.getJobId(jobId);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
}