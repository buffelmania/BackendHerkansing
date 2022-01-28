package com.example.AutoGarage.entity;

import javax.persistence.*;


@Entity(name = "Part")
@Table(name = "Part")
public class Part extends RepairItem{

    @Column(name = "PartName", nullable = false)
    private String PartName;

    @Column(name = "PartPrice", nullable = false)
    private Integer PartPrice;

    public Part(){}

    public Part(String PartName, Integer PartPrice) {

        this.PartName = PartName;
        this.PartPrice = PartPrice;

    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        PartName = partName;
    }

    public Integer getPartPrice() {
        return PartPrice;
    }

    public void setPartPrice(Integer partPrice) {
        PartPrice = partPrice;
    }

}
