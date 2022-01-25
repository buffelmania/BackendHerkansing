package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);


    // Methode toegevoegd voor ophalen van enkele customer;
    Customer getCustomer(Long customerId);


}
