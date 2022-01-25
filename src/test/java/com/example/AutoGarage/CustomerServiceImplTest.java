package com.example.AutoGarage;

import com.example.AutoGarage.controller.CustomerController;
import com.example.AutoGarage.entity.Customer;
import com.example.AutoGarage.repository.CustomerRepository;
import com.example.AutoGarage.service.CustomerService;
import com.example.AutoGarage.service.implementation.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    private CustomerServiceImpl customerServiceImpl;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerServiceImpl = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void shouldGetAllCustomers() {
        customerServiceImpl.getAllCustomers();
        Mockito.verify(customerRepository).findAll();
    }

    @Test
    void shouldGetCustomer() {
        Customer customer = new Customer(
                "Willem",
                "van der Bijl",
                "Willem@belastingdienst.nl",
                "112");

        Mockito.when(customerRepository.getById(1L)).thenReturn(customer);
        customerServiceImpl.getCustomer(1L);
        Mockito.verify(customerRepository).getById(1L);
    }

    @Test
    void shouldSaveCustomer() {
        Customer customer = new Customer(
                "Willem",
                "van der Bijl",
                "Willem@belastingdienst.nl",
                "112");

        customerServiceImpl.saveCustomer(customer);

        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        Mockito.verify(customerRepository).save(customerArgumentCaptor.capture());

        Customer capturedCustomer = customerArgumentCaptor.getValue();
        Assertions.assertThat(capturedCustomer).isEqualTo(customer);
    }
}

