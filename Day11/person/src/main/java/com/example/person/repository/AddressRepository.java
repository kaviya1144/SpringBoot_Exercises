package com.example.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.person.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // Custom queries if needed
}