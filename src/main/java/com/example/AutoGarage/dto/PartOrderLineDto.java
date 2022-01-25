package com.example.AutoGarage.dto;

public class PartOrderLineDto {
    private Long repairId;
    private String partName;
    private Integer partPrice;
    private Integer quantity;
    private Integer totalPrice;

    public PartOrderLineDto(Long repairId, String partName, Integer partPrice, Integer quantity,
                            Integer totalPrice) {
        this.repairId = repairId;
        this.partName = partName;
        this.partPrice = partPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(Integer partPrice) {
        this.partPrice = partPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "PartOrderLineDto{" +
                "repairId=" + repairId +
                ", partName='" + partName + '\'' +
                ", partPrice=" + partPrice +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
