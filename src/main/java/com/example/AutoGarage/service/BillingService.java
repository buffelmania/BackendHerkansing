package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Billing;

import java.util.List;

public interface BillingService {
    List<Billing>getAllBillings();
    Billing saveBilling(Long RepairId, Long CostumerContactId, Billing billing);

    Billing getBilling(Long BillingId);
}
