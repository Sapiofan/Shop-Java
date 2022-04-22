package com.example.shopjava.services;

import com.example.shopjava.entities.Product;

import java.util.List;

public interface FilterProducts {
    List<? extends Product> searchProducts(String keyword);
}
