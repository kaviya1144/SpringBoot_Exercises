package com.example.door.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.door.model.Door;
import com.example.door.repository.DoorRepo;

import jakarta.transaction.Transactional;

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

    public List<Door> getByColor(String color) {
        return doorRepo.findByColor(color);
    }

    public List<Door> getByDoorType(String doorType) {
        return doorRepo.findByDoorType(doorType);
    }

    @Transactional
    public void putDoor(int doorId, String color) {
         doorRepo.updateDoor(doorId,color);
    }

    public boolean deleteDoor(int doorId){
       Optional<Door> doorOptional = doorRepo.findByDoorId(doorId);
       if(doorOptional.isPresent()){
        doorRepo.deleteById(doorId);
        return true;
       }
       return false;
}
}
