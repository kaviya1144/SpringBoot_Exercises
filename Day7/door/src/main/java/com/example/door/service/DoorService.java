package com.example.door.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.door.model.Door;
import com.example.door.repository.DoorRepo;

@Service
public class DoorService {
    @Autowired
    private DoorRepo doorRepo;

    public Door createDoor(Door door) {
        return doorRepo.save(door);
    }

    public List<Door> getAllPatients() {
        return doorRepo.findAll();
    }

    public Door getDoorById(int doorId) {
        return doorRepo.findById(doorId);
    }
    public List<Door> getAccessType(String accessType) {
        return doorRepo.findByAccessType(accessType);
    }
}
