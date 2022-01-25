//package com.example.AutoGarage;
//
//import com.example.AutoGarage.entity.Car;
//import com.example.AutoGarage.entity.Customer;
//import com.example.AutoGarage.repository.CarRepository;
//import com.example.AutoGarage.repository.CustomerRepository;
//import com.example.AutoGarage.service.implementation.CarServiceImpl;
//import com.example.AutoGarage.service.implementation.CustomerServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//public class CarServiceImplTest {
//    private CarServiceImpl carServiceImpl;
//
//    @Mock
//    private CarRepository carRepository;
//
//    @BeforeEach
//    void setUp() {
//        carServiceImpl = new CarServiceImpl(carRepository);
//    }
//
//    @Test
//    void shouldGetAllCars() {
//        carServiceImpl.getAllCars();
//        Mockito.verify(carRepository).findAll();
//    }
//
//
//
//    @Test
//    void shouldSaveCar() {
//        Car car = new Car("Mazda", "Cx5", "23-df-56");
//
//        carServiceImpl.saveCar(car);
//
//
//
//        ArgumentCaptor<Car> carArgumentCaptor = ArgumentCaptor.forClass(Car.class);
//        Mockito.verify(carRepository).save(carArgumentCaptor.capture());
//
//        Car capturedCar = carArgumentCaptor.getValue();
//        Assertions.assertThat(capturedCar).isEqualTo(car);
//    }
//}
