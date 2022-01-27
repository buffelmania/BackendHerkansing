package com.example.AutoGarage.controller;

import com.example.AutoGarage.service.implementation.BillingServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BillingController {
    private final BillingServiceImpl billingService;

    public BillingController(BillingServiceImpl billingService) {
        this.billingService = billingService;
    }

    @PreAuthorize("hasRole('ROLE_BACKOFFICE')")
    @GetMapping(path = "factuur/{repairId}")
    public ResponseEntity<?> createInvoice(@PathVariable Long repairId) throws IOException {
        billingService.writeInvoice(repairId);

        return ResponseEntity.ok("Factuur gegenereerd in bestand op de computer in text format");
    }
}
