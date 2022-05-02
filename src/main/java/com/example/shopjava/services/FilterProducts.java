package com.example.shopjava.services;

import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilterProducts {
    List<? extends Product> searchProducts(String keyword);

    Map<String, List<String>> getPhoneCharacteristics();

    List<Phone> phones(Set<String> filters, Map<String, List<String>> fullFilters);

    List<Phone> getAllPhones();
}
