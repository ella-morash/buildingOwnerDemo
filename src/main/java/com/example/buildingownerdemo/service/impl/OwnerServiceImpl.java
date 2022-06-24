package com.example.buildingownerdemo.service.impl;

import com.example.buildingownerdemo.dto.OwnerDTO;
import com.example.buildingownerdemo.entity.Apartment;
import com.example.buildingownerdemo.entity.Building;
import com.example.buildingownerdemo.entity.Owner;
import com.example.buildingownerdemo.repository.ApartmentRepository;
import com.example.buildingownerdemo.repository.BuildingRepository;
import com.example.buildingownerdemo.repository.OwnerRepository;
import com.example.buildingownerdemo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private BuildingRepository buildingRepository;



    @Override
    public void moveOwnerIntoApartment(Long buildingId, Long apartmentId, Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No owner with %s id",ownerId)));

        Apartment apartment =apartmentRepository.findById(apartmentId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No owner with %s id",apartmentId)));

        Building building = buildingRepository.findById(buildingId)
                        .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No owner with %s id",buildingId)));

        owner.setApartment(apartment);
        apartment.setBuilding(building);
        apartment.setOwner(owner);

        ownerRepository.save(owner);
        apartmentRepository.save(apartment);
        buildingRepository.save(building);

    }

    @Override
    public void evictOwnerFromTheApartment(Long buildingId, Long apartmentId, Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No owner with %s id",ownerId)));

        Apartment apartment =apartmentRepository.findById(apartmentId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No owner with %s id",apartmentId)));

        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No owner with %s id",buildingId)));

        owner.setApartment(null);
        apartment.setOwner(null);

        ownerRepository.save(owner);
        apartmentRepository.save(apartment);


    }

    @Override
    public OwnerDTO getOwnerAndHisApartment(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No owner with %s id",ownerId)));
        return OwnerDTO.builder()
                .name(owner.getName())
                .apartment(owner.getApartment())
                .build();

    }
}
