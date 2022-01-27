package com.example.AutoGarage.controller;

import com.example.AutoGarage.entity.Customer;
import com.example.AutoGarage.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@CrossOrigin(origins = "*")
@RequestMapping(value = "/")
public class CustomerController {

    private CustomerService customerServiceImpl;

    public CustomerController(CustomerService customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @PreAuthorize("hasRole('ROLE_REGISTER')")
    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerServiceImpl.getAllCustomers());
        return "customers";

    }


    @GetMapping("/customers/new")
    public String createCustomersForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("Klant", customer);
        return "create_customer";

    }


    @PostMapping("/customers")
    public String saveStudent(@ModelAttribute("Klant") Customer customer) {
        customerServiceImpl.saveCustomer(customer);
        return "redirect:/customers";
    }

}
