package com.example.buildingownerdemo.service;

import com.example.buildingownerdemo.dto.ApartmentDTO;

import java.util.List;

public interface ApartmentService {
    List<ApartmentDTO> getAllApartments(Long buildingId, boolean hasOwners);


}
