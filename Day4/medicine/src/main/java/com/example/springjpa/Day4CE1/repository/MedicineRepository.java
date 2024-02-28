package com.example.springjpa.Day4CE1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.Day4CE1.model.MedicineDetails;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineDetails,Integer> {
    
}
