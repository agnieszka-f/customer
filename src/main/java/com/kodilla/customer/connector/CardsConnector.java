package com.kodilla.customer.connector;

import com.kodilla.customer.connector.response.GetCardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;

@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
public interface CardsConnector {

    @GetMapping(value = "/v1/cards/{customerId}")
    GetCardsResponse getCards(@PathVariable Long customerId);
}

@Component
@Slf4j
class CardsConnectorFallback implements CardsConnector{

    @Override
    public GetCardsResponse getCards(Long customerId) {
        log.warn("Can not get cards for customerId: {}", customerId);

        GetCardsResponse getCardsResponse = new GetCardsResponse();
        getCardsResponse.setCards(Collections.emptyList());
        return getCardsResponse;
    }
}
