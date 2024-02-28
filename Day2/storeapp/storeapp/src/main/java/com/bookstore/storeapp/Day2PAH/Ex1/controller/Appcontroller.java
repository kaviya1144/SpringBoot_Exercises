package com.bookstore.storeapp.Day2PAH.Ex1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bookstore.storeapp.Day2PAH.Ex1.config.Apiconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@Service
public class Appcontroller {
    
    @Autowired
    Apiconfig config;
    @GetMapping("/details")
   public String getApp() {
      return new String(config.getStudentName()+" "+config.getStudentDept());
   }
}
