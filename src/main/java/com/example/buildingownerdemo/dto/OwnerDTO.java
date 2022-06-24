package com.example.buildingownerdemo.dto;


import com.example.buildingownerdemo.entity.Apartment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class OwnerDTO {
   private String name;
   private Apartment apartment;
}
