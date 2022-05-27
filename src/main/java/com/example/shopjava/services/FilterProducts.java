package com.example.shopjava.services;

import com.example.shopjava.entities.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilterProducts {
    List<? extends Product> searchProducts(String keyword);

    List<Product> searchUncertainProducts(String keyword);

    Product getProductById(Long id);

    Map<String, List<String>> getPhoneCharacteristics();

    Map<String, List<String>> getDescTable(Product product);

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

    Page<Product> getAllProducts(int pageNum);

    List<Product> getProductsWithDiscount();

    Category getCategory(String category);

    void saveProduct(Product product);

    void savePhone(Phone phone);

    void saveLaptop(Laptop laptop);

    void saveWatch(Watch watch);

    void deleteById(Long id);

    List<Product> bestsellers();

    Map<String, String> descData(Product product);

}
