package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment>getAllAppointments();
    Appointment saveAppointment(Long repairId, Appointment appointment);

    Appointment getAppointment(Long AppointmentId);
}
