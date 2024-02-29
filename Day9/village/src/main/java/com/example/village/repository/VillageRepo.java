package com.example.village.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.village.model.Village;

public interface VillageRepo extends JpaRepository<Village,Integer>{
    @Query("Select v from Village v where v.villageName = :value")
    List<Village> findvillageName(String value);

    @Query("Select v from Village v where v.villagePopulation = :value")
    List<Village> findvillagePopulation(String value);
}
