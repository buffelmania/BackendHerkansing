package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.entity.Appointment;
import com.example.AutoGarage.entity.Car;
import com.example.AutoGarage.entity.Customer;
import com.example.AutoGarage.entity.Repair;
import com.example.AutoGarage.repository.AppointmentRepository;
import com.example.AutoGarage.service.AppointmentService;
import com.example.AutoGarage.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private RepairServiceImpl repairService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, RepairServiceImpl repairService){
        this.appointmentRepository = appointmentRepository;
        this.repairService = repairService;
    }

    @Override
    public List<Appointment>getAllAppointments(){return appointmentRepository.findAll();}

    @Override
    public Appointment getAppointment(Long appointmentId) {
        return appointmentRepository.getById(appointmentId);}

    @Override
    public Appointment saveAppointment(Long repairId, Appointment appointment){return null;}




}


