package com.example.buildingownerdemo.service;

import com.example.buildingownerdemo.dto.ApartmentDTO;
import com.example.buildingownerdemo.dto.BuildingDTO;

import java.util.List;

public interface BuildingService {

    void createBuilding(BuildingDTO buildingDTO,int apartmentsCount);
    List<BuildingDTO> getBuildingsByStreet(String street);

    void deleteBuilding(Long buildingId);
}
