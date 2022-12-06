package org.apple.cart.controller;


import org.apple.cart.model.CartResponse;
import org.apple.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/info")
    public ResponseEntity<CartResponse> getCartInfo() {

        Optional<CartResponse> res = cartService.getCartAndItemsInfo();
        return res.map(cartResponse -> new ResponseEntity<>(cartResponse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }
}
