package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Car;

import java.util.List;

public interface Carservice {
    List<Car> getAllCars();

    Car saveCar(Long customerId, Car car);
}
