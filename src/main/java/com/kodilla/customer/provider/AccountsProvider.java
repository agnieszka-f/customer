package com.kodilla.customer.provider;

import com.kodilla.customer.connector.AccountsConnector;
import com.kodilla.customer.connector.response.AccountDto;
import com.kodilla.customer.connector.response.GetAccountsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {

    private final AccountsConnector accountsConnector;

    public List<AccountDto> getCustomerAccounts(Long customerId){

        return accountsConnector.getAccounts(customerId).getAccounts()
                .stream()
                .map(x -> new AccountDto(x.getNrb(),x.getCurrency(),x.getAvailableFunds()))
                .collect(Collectors.toList());
    }
}
