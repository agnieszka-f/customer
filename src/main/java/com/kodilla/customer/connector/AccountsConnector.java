package com.kodilla.customer.connector;

import com.kodilla.customer.connector.response.AccountDto;
import com.kodilla.customer.connector.response.GetAccountsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FeignClient(name = "accounts", fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {

    @GetMapping("/v1/accounts/{customerId}")
    GetAccountsResponse getAccounts(@PathVariable Long customerId);
}
@Slf4j
@Component
class AccountsConnectorFallback implements AccountsConnector{

    @Override
    public GetAccountsResponse getAccounts(Long customerId) {
        log.warn("Can not get accounts for customerId: {}", customerId);

        GetAccountsResponse getAccountsResponse = new GetAccountsResponse();
        getAccountsResponse.setAccounts(Collections.emptyList());
        return getAccountsResponse;
    }
}
