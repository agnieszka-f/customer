package com.kodilla.customer.service;

import com.kodilla.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbCustomerService {
    @Autowired
    private CustomerRepository customerRepository;
}
