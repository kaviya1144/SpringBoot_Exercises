package com.example.door.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.door.model.Door;
import java.util.List;


@Repository
public interface DoorRepo extends JpaRepository<Door,Integer>{
    Door findById(int doorId);

    List<Door> findByAccessType(String accessType);
}
