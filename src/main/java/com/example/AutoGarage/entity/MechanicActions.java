package com.example.AutoGarage.entity;


import javax.persistence.*;

@Entity(name = "MechanicActions")
@Table(name = "monteuracties")
public class MechanicActions {
    @Id
    @Column(name = "monteuracties_id")
    private Long id;

    @Column(name = "soort_monteuracties")
    private String name;

    @Column(name = "prijs_monteuracties")
    private Double price;

//    @ManyToOne
//    private Repair repair;



    public MechanicActions(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public MechanicActions() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    public Repair getRepair() {
//        return repair;
//    }
//
//    public void setRepair(Repair repair) {
//        this.repair = repair;
//    }
}
