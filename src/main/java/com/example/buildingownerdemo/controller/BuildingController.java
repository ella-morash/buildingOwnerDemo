package com.example.buildingownerdemo.controller;

import com.example.buildingownerdemo.dto.ApartmentDTO;
import com.example.buildingownerdemo.dto.BuildingDTO;
import com.example.buildingownerdemo.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping(path = "/buildings/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBuilding(@RequestBody BuildingDTO buildingDTO,@RequestParam(name = "apartmentsCount")int  apartmentsCount) {
        buildingService.createBuilding(buildingDTO,apartmentsCount);
    }

    @GetMapping(path = "/buildings/")
    public List<BuildingDTO> getBuildingsByStreet(@RequestParam(name = "street")String street) {
        return buildingService.getBuildingsByStreet(street);
    }

    @DeleteMapping(path = "/buildings/{id}/demolish")
    public void deleteBuilding(@PathVariable("id") Long buildingId) {
        buildingService.deleteBuilding(buildingId);
    }

}
