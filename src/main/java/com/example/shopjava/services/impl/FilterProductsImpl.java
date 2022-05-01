package com.example.shopjava.services.impl;

import com.example.shopjava.entities.Filters;
import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;
import com.example.shopjava.repos.FilterProductsRepo;
import com.example.shopjava.repos.PhoneRepository;
import com.example.shopjava.repos.ProductRepository;
import com.example.shopjava.services.FilterProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.*;

@Service
public class FilterProductsImpl implements FilterProducts {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private FilterProductsRepo filterProductsRepo;

    @Transactional
    @Override
    public List<? extends Product> searchProducts(String keyword) {
        if(keyword != null){
            return productRepository.searchProducts(keyword);
        }
        return phoneRepository.findAll();
    }

    @Override
    public Map<String, List<String>> getPhoneCharacteristics() {
        Filters filters = new Filters();
        filters.initPhoneChars();
        return filters.phoneCharacteristics;
    }

    @Override
    public List<Phone> phones(Set<String> filters, Map<String, List<String>> fullFilters) {
        return filterProductsRepo.filterPhones(filters, fullFilters);
    }
}
