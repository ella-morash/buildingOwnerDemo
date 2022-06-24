package com.example.buildingownerdemo.service;

import com.example.buildingownerdemo.dto.OwnerDTO;

public interface OwnerService {
    void moveOwnerIntoApartment(Long buildingId, Long apartmentId, Long ownerId);

    void evictOwnerFromTheApartment(Long buildingId, Long apartmentId, Long ownerId);

    OwnerDTO getOwnerAndHisApartment(Long ownerId);
}
