package com.example.AutoGarage.controller;

import com.example.AutoGarage.entity.Repair;
import com.example.AutoGarage.service.RepairService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepairController {

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @PostMapping(path = "/reparatie/{carId}")
    public ResponseEntity<?> addRepairToCar(@PathVariable Long carId) {
        Repair repair = repairService.saveRepair(carId);
        return ResponseEntity.ok().body(repair);
    }
}
