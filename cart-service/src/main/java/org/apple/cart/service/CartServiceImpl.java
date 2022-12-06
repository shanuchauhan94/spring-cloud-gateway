package org.apple.cart.service;

import org.apple.cart.model.CartResponse;
import org.apple.cart.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CartServiceImpl implements CartService {

    private final RestTemplate restTemplate;
    private static final String ITEM_SERVICE_URL = "http://127.0.0.1:9092/item";

    @Autowired
    public CartServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<CartResponse> getCartAndItemsInfo() {
        List<Items> itemsList = getItemsList();
        CartResponse response = new CartResponse(UUID.randomUUID().toString(), 3, new Date(), itemsList);

        return Optional.of(response);
    }

    private List<Items> getItemsList() {
        ResponseEntity<List> items = restTemplate.getForEntity(ITEM_SERVICE_URL, List.class);
        if (Objects.nonNull(items.getBody())) {
            return items.getBody();
        }
        return new ArrayList<>();
    }
}
