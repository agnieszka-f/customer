package com.kodilla.customer.connector.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
//@AllArgsConstructor
public class GetAccountsResponse {

    private List<AccountDto> accounts;
}
