package com.kodilla.customer.controller;

import com.kodilla.customer.connector.response.AccountDto;
import com.kodilla.customer.controller.response.GetCustomerProductsResponse;
import com.kodilla.customer.domain.Customer;
import com.kodilla.customer.domain.CustomerDto;
import com.kodilla.customer.domain.GetCustomerResponse;
import com.kodilla.customer.mapper.CustomerMapper;
import com.kodilla.customer.repository.CustomerRepository;
import com.kodilla.customer.service.DbCustomerService;
import com.kodilla.customer.service.DbProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RefreshScope
@RestController
@RequestMapping(value = "/v1/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private DbCustomerService dbCustomerService;
    @Autowired
    private DbProductService dbProductService;

    @GetMapping(value="/{idCustomer}")
    public GetCustomerResponse getCustomer(@PathVariable Long idCustomer){

        return dbCustomerService.findCustomer(idCustomer)
                .map(x -> new GetCustomerResponse(customerMapper.mapToCustomerDto(x)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping(value = "/{idCustomer}/products")
    public GetCustomerProductsResponse getCustomerProducts(@PathVariable Long idCustomer){

        CustomerDto customerDto = dbCustomerService.findCustomer(idCustomer)
                .map(x -> customerMapper.mapToCustomerDto(x))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));


        List<AccountDto> customerAccounts = dbProductService.findCustomerAccounts(idCustomer);
        
        return GetCustomerProductsResponse.builder()
                .customerId(customerDto.getId())
                .fullName(customerDto.getFirstName() +" "+customerDto.getLastName())
                .accounts(customerAccounts).build();

    }
}
