package com.example.door.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.door.model.Door;
import java.util.List;
import java.util.Optional;

@Repository
public interface DoorRepo extends JpaRepository<Door,Integer>{
    Door findById(int doorId);

    List<Door> findByColor(String color);

    List<Door> findByDoorType(String doorType);

    Optional<Door>findByDoorId(int doorId);

    @Modifying
    @Query("update Door door set door.color = ?2 where door.doorId = ?1")
    void updateDoor(int doorId,String color);

    @Modifying
    @Query("delete from Door door where door.doorId = ?1")
    void deleteById(int doorId);
}
