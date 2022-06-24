package com.example.buildingownerdemo.controller;

import com.example.buildingownerdemo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OwnerController {

    @Autowired
    private OwnerService ownerService;
}
