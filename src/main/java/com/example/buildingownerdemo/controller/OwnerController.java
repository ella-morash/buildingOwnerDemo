package com.example.buildingownerdemo.controller;

import com.example.buildingownerdemo.dto.OwnerDTO;
import com.example.buildingownerdemo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class OwnerController {

    @Autowired
    private OwnerService ownerService;


    @PutMapping(path = "/api/buildings/{building_id}/apartments/{apartment_id}/owners/{owner_id}  ")
    void moveOwnerIntoApartment(@PathVariable("building_id") Long buildingId,
                                @PathVariable("apartment_id") Long apartmentId,
                                @PathVariable("owner_id") Long ownerId) {
        ownerService.moveOwnerIntoApartment(buildingId,apartmentId,ownerId);
    }

    @DeleteMapping(path = "/api/buildings/{building_id}/apartments/{apartment_id}/owners/{owner_id} ")
    void evictOwnerFromTheApartment(@PathVariable("building_id") Long buildingId,
                                    @PathVariable("apartment_id") Long apartmentId,
                                    @PathVariable("owner_id") Long ownerId) {
        ownerService.evictOwnerFromTheApartment(buildingId,apartmentId,ownerId);
    }

    @GetMapping(path = "/api/owners/{id} ")
    OwnerDTO getOwnerAndHisApartment(@PathVariable("id") Long ownerId) {
        return ownerService.getOwnerAndHisApartment(ownerId);
    }
}
