package com.kodilla.customer.provider;

import com.kodilla.customer.connector.CardsConnector;
import com.kodilla.customer.connector.response.CardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardsProvider {

    private final CardsConnector cardsConnector;

    public List<CardDto> getCustomerCards(Long customerId){
        return cardsConnector.getCards(customerId).getCards()
                .stream().map(x -> new CardDto(x.getType(),x.getNumber(),x.getExpiryDate(),x.getCvc()))
                .collect(Collectors.toList());
    }
}
