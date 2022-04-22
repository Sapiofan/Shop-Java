package com.example.shopjava.services.impl;

import com.example.shopjava.entities.Product;
import com.example.shopjava.repos.PhoneRepository;
import com.example.shopjava.repos.ProductRepository;
import com.example.shopjava.services.FilterProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilterProductsImpl implements FilterProducts {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Transactional
    public List<? extends Product> searchProducts(String keyword) {
        if(keyword != null){
            return productRepository.searchProducts(keyword);
        }
        return phoneRepository.findAll();
    }
}
