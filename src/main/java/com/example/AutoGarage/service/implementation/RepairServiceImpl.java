package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.entity.Car;
import com.example.AutoGarage.entity.Repair;
import com.example.AutoGarage.repository.CarRepository;
import com.example.AutoGarage.repository.RepairRepository;
import com.example.AutoGarage.service.RepairService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;
    private final CarRepository carrepository;

    public RepairServiceImpl(RepairRepository repairRepository, CarRepository carrepository) {
        this.repairRepository = repairRepository;
        this.carrepository = carrepository;
    }

    @Override
    public List<Repair> getAllRepairs() {
        return null;
    }

    @Override
    public Repair saveRepair(Long carId) {
        Car car = carrepository.getById(carId);
        Repair repair = new Repair();
        repair.setCar(car);
        return repairRepository.save(repair);

    }


    @Override
    public Repair getRepair(Long RepairId) {
        return null;
    }
}
