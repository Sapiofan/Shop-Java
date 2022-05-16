package com.example.shopjava.services;

import com.example.shopjava.entities.Favorite;
import com.example.shopjava.entities.Product;

import java.util.Set;

public interface FavoriteService {
    Favorite addProduct(Favorite favorite, Long productId);

    Favorite getUserProducts(Long id);

    Favorite deleteProduct(Favorite favorite, Long productId);

    Favorite cleanFavorites(Favorite favorite);
}
