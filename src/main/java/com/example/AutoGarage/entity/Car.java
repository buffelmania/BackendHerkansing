package com.example.AutoGarage.entity;


import javax.persistence.*;

@Entity(name = "Cars")
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merk", nullable = false)
    private String merk;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "kenteken", nullable = false)
    private String registrationplate;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "car",fetch = FetchType.EAGER)
    private Repair repair;

    public Car(){

    }

    public Car(String merk, String model, String registrationplate) {
        this.merk = merk;
        this.model = model;
        this.registrationplate = registrationplate;

    }

    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public String getMerk() {
        return merk;
    }
    public void setMerk(String brand) {
        this.merk = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationplate() {
        return registrationplate;
    }

    public void setRegistrationplate(String registrationplate) {
        this.registrationplate = registrationplate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}
