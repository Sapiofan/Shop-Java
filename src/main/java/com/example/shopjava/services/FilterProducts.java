package com.example.shopjava.services;

import com.example.shopjava.entities.Laptop;
import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;
import com.example.shopjava.entities.Watch;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilterProducts {
    List<? extends Product> searchProducts(String keyword);

    Map<String, List<String>> getPhoneCharacteristics();

    Map<String, List<String>> getLaptopCharacteristics();

    Map<String, List<String>> getWatchCharacteristics();

    List<Phone> phones(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max);

    List<Phone> getAllPhones();

    Phone getPhoneByName(String name);

    Phone getPhoneById(Long id);

    List<Phone> sort(List<Phone> phones, String sortType);

    List<Laptop> getAllLaptops();

    List<Laptop> laptops(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max);

    List<Watch> getAllWatches();

    List<Watch> watches(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max);

    List<Product> getAllProducts();

    List<Product> getProductsWithDiscount();

    void deleteById(Long id);

}
