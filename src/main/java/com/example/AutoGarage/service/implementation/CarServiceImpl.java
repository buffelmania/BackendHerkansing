package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.entity.Car;
import com.example.AutoGarage.entity.Customer;
import com.example.AutoGarage.repository.CarRepository;
import com.example.AutoGarage.service.Carservice;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarServiceImpl implements Carservice {

    private CarRepository carRepository;
    private CustomerServiceImpl customerService;

    public CarServiceImpl(CarRepository carRepository, CustomerServiceImpl customerService) {
        this.carRepository = carRepository;
        this.customerService = customerService;
    }


    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Long customerId, Car car) {
        Customer customer = customerService.getCustomer(customerId);
        car.setCustomer(customer);
        return carRepository.save(car);
    }

}
