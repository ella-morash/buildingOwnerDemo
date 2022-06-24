package com.example.buildingownerdemo.repository;

import com.example.buildingownerdemo.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment,Long> {

    List<Apartment> findAllByBuilding_Id (Long id);

    List<Apartment> findApartmentsByBuilding_IdAndOwnerIsNotNull(Long id);


}
