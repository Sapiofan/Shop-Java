package com.example.shopjava.repos;

import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilterProductsRepo {
    List<Phone> filterPhones(Set<String> filters, Map<String, List<String>> fullFilters);
}
