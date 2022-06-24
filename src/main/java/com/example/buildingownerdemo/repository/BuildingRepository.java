package com.example.buildingownerdemo.repository;


import com.example.buildingownerdemo.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building,Long> {

    List<Building> findAllByStreet(String street);
}
