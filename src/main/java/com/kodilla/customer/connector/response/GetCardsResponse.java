package com.kodilla.customer.connector.response;

import lombok.Data;

import java.util.List;

@Data
public class GetCardsResponse {
    private List<CardDto> cards;
}
