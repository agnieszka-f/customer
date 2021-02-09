package com.kodilla.customer.controller;

import com.kodilla.customer.domain.Customer;
import com.kodilla.customer.domain.GetCustomerResponse;
import com.kodilla.customer.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping(method = RequestMethod.GET, value="/customer/{idCustomer}")
    public GetCustomerResponse getCustomerById(@PathVariable Long idCustomer){

        Customer customer = new Customer(1234L, "Jan", "Kowalski");
        return new GetCustomerResponse(customerMapper.mapToCustomerDto(customer));
    }
}
