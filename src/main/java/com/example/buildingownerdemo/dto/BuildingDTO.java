package com.example.buildingownerdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class BuildingDTO {

    private Long id;
    private String street;
    private String house;
    private int apartmentsCount;
}
