package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Part;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PartService {

    List<Part>getAllParts();
    Part saveParts(Long RepairId, Part part);

    Part getPart(Long PartId);

}
