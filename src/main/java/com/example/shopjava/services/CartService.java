package com.example.shopjava.services;

import com.example.shopjava.entities.Cart;

public interface CartService {
    Cart addProduct(Cart cart, Long productId);

    Cart getUserProducts(Long id);

    Cart deleteProduct(Cart cart, Long productId);
}
