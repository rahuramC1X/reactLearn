package com.example.ext.service;

import com.example.ext.dao.CustomerDao;
import com.example.ext.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers() throws InterruptedException {

        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println();
        return customers;

    }

    public Flux<Customer> loadAllCustomerStream() throws InterruptedException {

        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution time:" + (end -start));
        return customers;

    }
}
