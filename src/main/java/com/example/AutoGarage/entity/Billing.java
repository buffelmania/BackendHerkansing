package com.example.AutoGarage.entity;


import javax.persistence.*;

@Entity(name = "Billing")
@Table(name = "Billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TotalCosts", nullable = false)
    private String totalCosts;


    public Billing() {

    }

    public Billing(String totalCosts) {

        this.totalCosts = totalCosts;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(String totalCosts) {
        this.totalCosts = totalCosts;
    }


}

