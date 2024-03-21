package com.example.ext.controller;


import com.example.ext.dto.Customer;
import com.example.ext.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomers() throws InterruptedException {
        return customerService.loadAllCustomers();
    }

    @GetMapping(value = "/stream" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() throws InterruptedException {
        return customerService.loadAllCustomerStream();
    }
}
