package com.example.buildingownerdemo.controller;

import com.example.buildingownerdemo.dto.ApartmentDTO;
import com.example.buildingownerdemo.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping(path = "/api/buildings/{id}/apartments")//?hasOwners=true
    public List<ApartmentDTO> getAllApartments (@PathVariable("id") Long buildingId,
                                                @RequestParam(name = "hasOwners",required = false) boolean hasOwners) {
        return apartmentService.getAllApartments(buildingId,hasOwners);
    }
}
