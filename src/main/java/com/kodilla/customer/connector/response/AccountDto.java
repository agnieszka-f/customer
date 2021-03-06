package com.kodilla.customer.connector.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class AccountDto {
    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
}
