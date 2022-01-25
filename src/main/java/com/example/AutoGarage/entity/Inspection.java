package com.example.AutoGarage.entity;


import javax.persistence.*;

@Entity(name = "Inspection")
@Table(name = "Inspection")
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VerwachteKosten", nullable = false)
    private String EstimatedCosts;


    @OneToOne
    private Car car;

    public Inspection(){

    }

    public Inspection(String EstimatedCosts) {

        this.EstimatedCosts = EstimatedCosts;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstimatedCosts() {
        return EstimatedCosts;
    }

    public void setEstimatedCosts(String estimatedCosts) {
        EstimatedCosts = estimatedCosts;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
