package com.example.buildingownerdemo.service;

import com.example.buildingownerdemo.dto.ApartmentDTO;
import com.example.buildingownerdemo.dto.BuildingDTO;

import java.util.List;

public interface BuildingService {

    void createBuilding(BuildingDTO buildingDTO,boolean apartmentsCount);
    List<BuildingDTO> getBuildingsByStreet(String street);
}
