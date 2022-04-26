package com.example.shopjava.services;

import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;

import java.util.List;
import java.util.Map;

public interface FilterProducts {
    List<? extends Product> searchProducts(String keyword);

    Map<String, List<String>> getPhoneCharacteristics();
}
