package com.example.buildingownerdemo.dto;

import com.example.buildingownerdemo.entity.Building;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ApartmentDTO {
    private Integer apartmentNumber;
    private Boolean hasBalcony;
    private Building building;
}
