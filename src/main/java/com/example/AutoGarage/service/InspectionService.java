package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Inspection;

import java.util.List;

public interface InspectionService {
    List<Inspection> getAllInspections();
    Inspection saveInspection(Long CarId, Inspection inspection);

    Inspection getInspection(Long InspectionId);

}
