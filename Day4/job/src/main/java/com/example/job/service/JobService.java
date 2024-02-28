package com.example.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job.model.JobModel;
import com.example.job.repository.JobRepository;

@Service
public class JobService {
    
    private final JobRepository jobRepo;
    @Autowired
    JobRepository repo;
    private JobService(JobRepository jobRepo)
    {
        this.jobRepo=jobRepo;
    }
   public JobModel createJob(JobModel job)
   {
        return jobRepo.save(job);
   }
   public List<JobModel> getAllJobs()
   {
    return jobRepo.findAll();
   }
   public JobModel getJobId(int jobId)
   {
    return jobRepo.findById(jobId).orElse(null);
   }
}
