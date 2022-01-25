package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.RepairPartLine;

public interface RepairPartLineService {
    RepairPartLine saveRepairPartLine(Long repairId, Long partId);
}
