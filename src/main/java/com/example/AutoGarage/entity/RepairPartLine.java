package com.example.AutoGarage.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
public class RepairPartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairPartLineId;

    private Long partId;

    private String description;

    private Integer quantity;

    private Integer totalPrice;

//    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
//    @JsonIdentityReference(alwaysAsId=true)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @ManyToOne(cascade = CascadeType.MERGE)
    private Repair repair;

    public RepairPartLine() {
        if(quantity == null) {
            quantity = 1;
        }
    }

    public Long getRepairPartLineId() {
        return repairPartLineId;
    }

    public void setRepairPartLineId(Long id) {
        this.repairPartLineId = id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
