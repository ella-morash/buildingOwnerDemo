package com.example.buildingownerdemo.service.impl;

import com.example.buildingownerdemo.dto.ApartmentDTO;
import com.example.buildingownerdemo.entity.Apartment;
import com.example.buildingownerdemo.repository.ApartmentRepository;
import com.example.buildingownerdemo.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public List<ApartmentDTO> getAllApartments(Long buildingId, boolean hasOwners) {
        List<Apartment> apartments = new ArrayList<>();
        if (hasOwners) {
            apartments = apartmentRepository
                    .findApartmentsByBuilding_IdAndOwnerIsNotNull(buildingId);



        } else {
           apartments = apartmentRepository.findAllByBuilding_Id(buildingId);


        }
        return  apartments.stream().map(apartment ->
                ApartmentDTO.builder()
                        .apartmentNumber(apartment.getApartmentNumber())
                        .hasBalcony(apartment.getHasBalcony())
                        .building(apartment.getBuilding())
                        .build()
        ).collect(Collectors.toList());
    }
}
