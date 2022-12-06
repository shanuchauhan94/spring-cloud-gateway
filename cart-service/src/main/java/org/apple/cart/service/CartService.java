package org.apple.cart.service;

import org.apple.cart.model.CartResponse;

import java.util.Optional;

public interface CartService {

    Optional<CartResponse> getCartAndItemsInfo();
}
