package com.example.person.service;

import com.example.person.model.Address;


public interface AddressService {
    Address mapAddressToPerson(Long personId, Address address);
}