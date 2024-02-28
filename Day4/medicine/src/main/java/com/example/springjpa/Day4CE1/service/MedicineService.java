package com.example.springjpa.Day4CE1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springjpa.Day4CE1.model.MedicineDetails;
import com.example.springjpa.Day4CE1.repository.MedicineRepository;

@Service
public class MedicineService {
    
    private MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }
    public MedicineDetails savMedicineDetails(MedicineDetails medicineDetails)
    {
        return medicineRepository.save(medicineDetails);
    }
    public List<MedicineDetails>listOfMedicines(){
        return medicineRepository.findAll();
    }
    public MedicineDetails objectMedicine(int medicineId)
    {
        Optional<MedicineDetails>obj = medicineRepository.findById(medicineId);
        return obj.orElse(new MedicineDetails());

    }
}
