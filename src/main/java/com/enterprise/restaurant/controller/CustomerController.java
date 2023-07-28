package com.enterprise.restaurant.controller;

import com.enterprise.restaurant.model.Customer;
import com.enterprise.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getall")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
}
