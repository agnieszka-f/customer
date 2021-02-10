package com.kodilla.customer.service;

import com.kodilla.customer.domain.Customer;
import com.kodilla.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbCustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findCustomer(Long id){
        //return customerRepository.findCustomerById(id);
        return Optional.of(new Customer(1234L, "Jan", "Kowalski"));
    }
}
