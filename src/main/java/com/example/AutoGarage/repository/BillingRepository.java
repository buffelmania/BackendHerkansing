package com.example.AutoGarage.repository;

import com.example.AutoGarage.dto.CustomerDto;
import com.example.AutoGarage.dto.PartOrderLineDto;
import com.example.AutoGarage.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {

    @Query("SELECT new com.example.AutoGarage.dto.CustomerDto(" +
            "c.id,c.firstName,c.lastName,c.email,c.phoneNR," +
            "a.merk,a.model,a.registrationplate) " +
            "FROM Customer as c " +
            "INNER JOIN Cars as a " +
            "ON a.id = ?1")
    CustomerDto getCustomerData(Long carId);

    @Query("SELECT new com.example.AutoGarage.dto.PartOrderLineDto( " +
            "reparatie.id,part.PartName,part.PartPrice," +
            "regel.quantity, regel.totalPrice) " +
            "FROM Repair as reparatie " +
            "INNER JOIN RepairPartLine as regel on reparatie.id = regel.repair.id " +
            "INNER JOIN Part as part on part.id = regel.partId " +
            "WHERE reparatie.id = ?1")
    List<PartOrderLineDto> getPartOrderLines(Long repairId);
}
