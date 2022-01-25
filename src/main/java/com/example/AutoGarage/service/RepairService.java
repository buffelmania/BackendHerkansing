package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Repair;

import java.util.List;

public interface RepairService {

    List<Repair>getAllRepairs();
    Repair saveRepair(Long carId);

    Repair getRepair(Long RepairId);

}
