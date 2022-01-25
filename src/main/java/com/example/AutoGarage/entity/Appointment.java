package com.example.AutoGarage.entity;


import javax.persistence.*;

@Entity(name = "Appointment")
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PickUpDate", nullable = false)
    private String PickUpDate;

    @OneToOne
    private Repair repair;

    public Appointment(){

    }

    public Appointment(String PickUpDate) {

        this.PickUpDate = PickUpDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickUpDate() {
        return PickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        PickUpDate = pickUpDate;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }
}
