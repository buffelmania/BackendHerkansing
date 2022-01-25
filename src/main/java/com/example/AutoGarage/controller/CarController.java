package com.example.AutoGarage.controller;


import com.example.AutoGarage.entity.Car;
import com.example.AutoGarage.service.Carservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    //private final Carservice carService;
    private Carservice carService;


    @Autowired
    public CarController(Carservice carService) {

        this.carService = carService;
    }

    @GetMapping("/cars")
    public String listCars(Model model) {
//        model.addAttribute("Car", carService.getAllCars());
        model.addAttribute("cars", carService.getAllCars());
        return "cars";

    }

    @GetMapping("/cars/new/{customerId}")
    public String createCarsFrom(@PathVariable("customerId") long customerId,Model model){
        System.out.println("id van url customer:" + customerId);
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("customerId",customerId);
        return "create_car";

    }

    @PostMapping("/cars/{customerId}")
    public String saveStudent(@PathVariable Long customerId, Car car, Model model) {
        System.out.println("PostMapping!!!");
        carService.saveCar(customerId, car);
        return "redirect:/cars";

    }
}
