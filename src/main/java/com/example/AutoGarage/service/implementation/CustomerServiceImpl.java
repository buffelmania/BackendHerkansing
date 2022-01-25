package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.entity.Customer;
import com.example.AutoGarage.repository.CustomerRepository;
import com.example.AutoGarage.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId){
        return customerRepository.getById(customerId);
    }

    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

}
