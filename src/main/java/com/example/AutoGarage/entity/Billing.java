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

//    @OneToOne
//    private Repair repair;

//    @OneToOne
//    private CustomerContact customerContact;

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

//    public Repair getRepair() {
//        return repair;
//    }
//
//    public void setRepair(Repair repair) {
//        this.repair = repair;
//    }

//    public CustomerContact getCustomerContact() {
//        return customerContact;
//    }
//
//    public void setCustomerContact(CustomerContact customerContact) {
//        this.customerContact = customerContact;
//    }
}

