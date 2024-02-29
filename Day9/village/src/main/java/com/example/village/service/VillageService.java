package com.example.village.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.village.model.Village;
import com.example.village.repository.VillageRepo;

@Service
public class VillageService {

    @Autowired
    private VillageRepo villageRepo;

    public Village postvillage(Village village) {
        return villageRepo.save(village);
    }

    public List<Village> getRName(String value) {
        return villageRepo.findvillageName(value);
    }

    public List<Village> getPopulation(String value) {
        return villageRepo.findvillagePopulation(value);
    }

    public Village getId(int villageId) {
        Optional<Village> obj =  villageRepo.findById(villageId);
        return obj.orElse(new Village());
    }
}
