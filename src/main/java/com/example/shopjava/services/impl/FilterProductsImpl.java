package com.example.shopjava.services.impl;

import com.example.shopjava.entities.*;
import com.example.shopjava.repos.*;
import com.example.shopjava.services.FilterProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FilterProductsImpl implements FilterProducts {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private FilterProductsRepo filterProductsRepo;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private WatchRepository watchRepository;

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
    public Map<String, List<String>> getLaptopCharacteristics() {
        Filters filters = new Filters();
        filters.initLaptopChars();
        return filters.laptopCharacteristics;
    }

    @Override
    public Map<String, List<String>> getWatchCharacteristics() {
        Filters filters = new Filters();
        filters.initWatchChars();
        return filters.watchCharacteristics;
    }

    @Override
    @Transactional
    public List<Phone> phones(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max) {
        return filterProductsRepo.filterPhones(filters, fullFilters, min, max);
    }

    @Override
    @Transactional
    public List<Phone> getAllPhones(){
        return phoneRepository.findAll();
    }

    @Override
    @Transactional
    public Phone getPhoneByName(String name) {
        return phoneRepository.getPhoneByName(name);
    }

    @Override
    @Transactional
    public Phone getPhoneById(Long id) {
        return phoneRepository.getPhoneById(id);
    }

    @Override
    public List<Phone> sort(List<Phone> phones, String sortType) {
        switch (sortType){
            case "From cheap to expensive":
                return sortFromCheapToExp(phones);
            case "From expensive to cheap":
                return sortFromExpToCheap(phones);
            case "By popularity":
                return sortByPopularity(phones);
            case "Novelties":
                return sortByNovelties(phones);
            case "By name":
                return sortByName(phones);
        }
        return null;
    }

    @Override
    @Transactional
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    @Transactional
    public List<Laptop> laptops(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max) {
        return filterProductsRepo.filterLaptops(filters, fullFilters, min, max);
    }

    @Override
    @Transactional
    public List<Watch> getAllWatches() {
        return watchRepository.findAllWatches();
    }

    @Override
    @Transactional
    public List<Watch> watches(Set<String> filters, Map<String, List<String>> fullFilters, Integer min, Integer max) {
        return filterProductsRepo.filterWatches(filters, fullFilters, min, max);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsWithDiscount() {
        return productRepository.discounts();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Phone> sortFromCheapToExp(List<Phone> phones) {
        return phones.stream()
                .sorted(Comparator.comparingDouble(Phone::getPrice))
                .collect(Collectors.toList());
    }

    public List<Phone> sortFromExpToCheap(List<Phone> phones) {
        return phones.stream()
                .sorted(Comparator.comparingDouble(Phone::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public List<Phone> sortByPopularity(List<Phone> phones) {
        return null;
    }

    public List<Phone> sortByNovelties(List<Phone> phones) {
        return null;
    }

    public List<Phone> sortByName(List<Phone> phones) {
        return phones.stream()
                .sorted(Comparator.comparing(Phone::getName))
                .collect(Collectors.toList());
    }
}
