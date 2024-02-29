package com.example.village.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.village.model.Village;
import com.example.village.service.VillageService;

@RestController
public class VillageController {

    @Autowired
    private VillageService villageService;

    @PostMapping("/village")
    public ResponseEntity<Village> post(@RequestBody Village village) {

        try {
            Village store = villageService.postvillage(village);
            return new ResponseEntity<>(store, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/village/byname/{value}")
    public ResponseEntity<List<Village>> getName(@PathVariable("value") String value) {
        List<Village> max = villageService.getRName(value);
        if (max != null) {
            return new ResponseEntity<>(max, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/village/villagepopulation/{value}")
    public ResponseEntity<List<Village>> getVillagePopulation(@PathVariable("value") String value) {
        List<Village> max = villageService.getPopulation(value);
        if (max != null) {
            return new ResponseEntity<>(max, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/village/{villageId}")
    public ResponseEntity<Village> getVillageId(@PathVariable("villageId") int villageId) {
        Village max = villageService.getId(villageId);
        if (max != null) {
            return new ResponseEntity<>(max, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
