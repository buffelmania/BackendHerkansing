package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.entity.Part;
import com.example.AutoGarage.repository.PartRepository;
import com.example.AutoGarage.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    private PartRepository partRepository;
    private RepairServiceImpl repairService;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, RepairServiceImpl repairService){
        this.partRepository = partRepository;
        this.repairService = repairService;
    }

    @Override
    public List<Part> getAllParts() {
        return null;
    }

    @Override
    public Part saveParts(Long RepairId, Part part) {
        return null;
    }

    @Override
    public Part getPart(Long PartId) {
        return null;
    }
}
