package com.example.springjpa.Day4CE1.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.example.springjpa.Day4CE1.model.MedicineDetails;
import com.example.springjpa.Day4CE1.service.MedicineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class MedicineController {

    private MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/postmedicine")
    public MedicineDetails postMedicine(@RequestBody MedicineDetails medicineDetails) {
        return medicineService.savMedicineDetails(medicineDetails);
    }

    @GetMapping("/getmedicine")

    public ResponseEntity<List>getMedicine(){
        List<MedicineDetails> b = medicineService.listOfMedicines();

        if(b.size() == 0){
            return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b,HttpStatus.CREATED);

    }


    @GetMapping("/api/medicine/{medicineid}")
    public MedicineDetails getobjectMedicine(@PathVariable ("medicineid") int medicineId) {
        return medicineService.objectMedicine(medicineId);
    }
}
