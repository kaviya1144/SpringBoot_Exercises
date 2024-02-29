package com.example.door.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.door.model.Door;
import com.example.door.service.DoorService;

@RestController
public class DoorController {

    @Autowired
    private DoorService doorService;

   

    public DoorController(DoorService doorService) {
        this.doorService = doorService;
    }

    @PostMapping("/api/Door")
    public ResponseEntity<Door> createDoor(@RequestBody Door Door) {
        try {
            Door createdDoor = doorService.createDoor(Door);
            return new ResponseEntity<>(createdDoor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/Door")
    public ResponseEntity<List<Door>> getAllDoors() {
        List<Door> Doors = doorService.getAllPatients();
        if (!Doors.isEmpty()) {
            return new ResponseEntity<>(Doors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/door/{doorId}")
    public ResponseEntity<Door> getByDoorId(@PathVariable("doorId") int doorId) {
        Door d = doorService.getDoorById(doorId);
        if (d != null) {
            return new ResponseEntity<>(d, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/door/accessType/{accessType}")
    public ResponseEntity<List<Door>> getAccess(@PathVariable("accessType") String accessType) {
        List<Door> d = doorService.getAccessType(accessType);
        if (d != null) {
            return new ResponseEntity<>(d, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
