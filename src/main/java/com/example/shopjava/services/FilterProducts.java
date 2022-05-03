package com.example.shopjava.services;

import com.example.shopjava.entities.Laptop;
import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilterProducts {
    List<? extends Product> searchProducts(String keyword);

    Map<String, List<String>> getPhoneCharacteristics();

    Map<String, List<String>> getLaptopCharacteristics();

    List<Phone> phones(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max);

    List<Phone> getAllPhones();

    List<Phone> sort(List<Phone> phones, String sortType);

    List<Laptop> getAllLaptops();

    List<Laptop> laptops(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max);

}
