package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.entity.Part;
import com.example.AutoGarage.entity.Repair;
import com.example.AutoGarage.entity.RepairPartLine;
import com.example.AutoGarage.repository.PartRepository;
import com.example.AutoGarage.repository.RepairPartLineRepository;
import com.example.AutoGarage.repository.RepairRepository;
import com.example.AutoGarage.service.RepairPartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairPartLineServiceImpl implements RepairPartLineService{

    private RepairPartLineRepository repairPartLineRepository;
    private RepairRepository repairRepository;
    private final PartRepository partRepository;

    @Autowired
    public RepairPartLineServiceImpl(RepairPartLineRepository repairPartLineRepository,
                                     RepairRepository repairRepository,
                                     PartRepository partRepository) {
        this.repairPartLineRepository = repairPartLineRepository;
        this.repairRepository = repairRepository;
        this.partRepository = partRepository;
    }

    @Override
    public RepairPartLine saveRepairPartLine(Long repairId,Long partId) {

        Repair repair = repairRepository.getById(repairId);
        Part part = partRepository.getById(partId);

        RepairPartLine repairPartLine = new RepairPartLine();

        repairPartLine.setPartId(partId);
        repairPartLine.setTotalPrice(part.getPartPrice());
        repairPartLine.setRepair(repair);
        repairPartLine.setDescription(part.getPartName());
        return repairPartLineRepository.save(repairPartLine);
    }
}
