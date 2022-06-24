package com.example.buildingownerdemo.service.impl;

import com.example.buildingownerdemo.dto.ApartmentDTO;
import com.example.buildingownerdemo.dto.BuildingDTO;
import com.example.buildingownerdemo.entity.Apartment;
import com.example.buildingownerdemo.entity.Building;
import com.example.buildingownerdemo.repository.ApartmentRepository;
import com.example.buildingownerdemo.repository.BuildingRepository;
import com.example.buildingownerdemo.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
     @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public void createBuilding(BuildingDTO buildingDTO, int  apartmentsCount) {

        if (apartmentsCount!=0) {
            buildingRepository.save(convertToBuilding(buildingDTO));
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("Field %b must be filled",apartmentsCount));
        }


    }

    @Override
    public List<BuildingDTO> getBuildingsByStreet(String street) {
        List<Building> buildings = buildingRepository.findAllByStreet(street);
        if (buildings.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("No such buildings on the %s street",street));
        }
        return buildings.stream().map(building ->
                BuildingDTO.builder()
                        .id(building.getId())
                        .house(building.getHouse())
                        .street(building.getStreet())
                        .apartmentsCount(apartmentRepository.findAllByBuilding_Id(building.getId()).size())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public void deleteBuilding(Long buildingId) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("No owner with %s id",buildingId)));
        buildingRepository.delete(building);

    }

    private Building convertToBuilding(BuildingDTO buildingDTO) {
        return Building.builder()
                .house(buildingDTO.getHouse())
                .street(buildingDTO.getStreet())
                .build();

    }
}
