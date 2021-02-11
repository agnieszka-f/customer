package com.kodilla.customer.connector.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDto {
    private CardType type;
    private String number;
    private String expiryDate;
    private String cvc;
}
