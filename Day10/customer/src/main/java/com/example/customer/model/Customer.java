package com.example.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    
    @Id
    private int customerId;
    private String customerName;
    private String city;
    private String address;
    private int pincode;
}
