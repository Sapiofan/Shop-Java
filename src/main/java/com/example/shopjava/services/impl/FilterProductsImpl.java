package com.example.shopjava.services.impl;

import com.example.shopjava.entities.Filters;
import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Product;
import com.example.shopjava.repos.PhoneRepository;
import com.example.shopjava.repos.ProductRepository;
import com.example.shopjava.services.FilterProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilterProductsImpl implements FilterProducts {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PhoneRepository phoneRepository;

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
}
