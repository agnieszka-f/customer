package com.kodilla.customer.service;

import com.kodilla.customer.connector.response.AccountDto;
import com.kodilla.customer.connector.response.CardDto;
import com.kodilla.customer.provider.AccountsProvider;
import com.kodilla.customer.provider.CardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbProductService {

    private final AccountsProvider accountsProvider;
    private final CardsProvider cardsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId){
        return accountsProvider.getCustomerAccounts(customerId);
    }
    public List<CardDto> findCustomerCards(Long customerId){
        return cardsProvider.getCustomerCards(customerId);
    }
}
