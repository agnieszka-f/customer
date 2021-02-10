package com.kodilla.customer.service;

import com.kodilla.customer.connector.response.AccountDto;
import com.kodilla.customer.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbProductService {

    private final AccountsProvider accountsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId){
        return accountsProvider.getCustomerAccounts(customerId);
    }
}
