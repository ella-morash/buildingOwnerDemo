package com.example.buildingownerdemo.repository;


import com.example.buildingownerdemo.entity.Apartment;
import com.example.buildingownerdemo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Long> {


}
