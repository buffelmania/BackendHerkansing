package com.example.AutoGarage.controller;

import com.example.AutoGarage.entity.RepairPartLine;
import com.example.AutoGarage.service.RepairPartLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepairPartLineController {
    private final RepairPartLineService repairLineService;

    public RepairPartLineController(RepairPartLineService repairLineService) {
        this.repairLineService = repairLineService;
    }

    @PostMapping(path = "onderdeel-toevoegen/{repairId}")
    public ResponseEntity<?> addRepairPartLine(@PathVariable() Long repairId, @RequestParam("partid") String partId) {
        Long parsedId = Long.parseLong(partId);
        RepairPartLine repairPartLIne = repairLineService.saveRepairPartLine(repairId,parsedId);
        return ResponseEntity.ok(repairPartLIne);
    }
}
