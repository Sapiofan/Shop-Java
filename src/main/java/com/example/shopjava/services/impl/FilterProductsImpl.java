package com.example.shopjava.services.impl;

import com.example.shopjava.entities.*;
import com.example.shopjava.repos.*;
import com.example.shopjava.services.FilterProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public List<? extends Product> searchProducts(String keyword) {
        if (keyword != null) {
            return productRepository.searchProducts(keyword);
        }
        return phoneRepository.findAll();
    }

    @Override
    public List<Product> searchUncertainProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Map<String, List<String>> getPhoneCharacteristics() {
        Filters filters = new Filters();
        filters.initPhoneChars();
        return filters.phoneCharacteristics;
    }

    @Override
    public Map<String, List<String>> getDescTable(Product product) {
        if (product.getCategory().getId() == 1) {
            Filters filters = new Filters();
            filters.initPhoneChars();
            return filters.descriptionTablePhone;
        } else if (product.getCategory().getId() == 2) {
            Filters filters = new Filters();
            filters.initLaptopChars();
            return filters.descriptionTableLaptop;
        } else if (product.getCategory().getId() == 3) {
            Filters filters = new Filters();
            filters.initWatchChars();
            return filters.descriptionTableWatch;
        }
        return null;
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
    public List<Phone> getAllPhones() {
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
        switch (sortType) {
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
    public Page<Product> getAllProducts(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, 10, Sort.by("name").ascending());
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> getProductsWithDiscount() {
        return productRepository.discounts();
    }

    @Override
    public Category getCategory(String category) {
        return categoryRepository.getCategoryByName(category);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void saveLaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    @Override
    public void saveWatch(Watch watch) {
        watchRepository.save(watch);
    }

    @Override
    public void savePhone(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Product> bestsellers() {
        List<Product> products = productRepository.findAll();
        return products.stream().sorted(Comparator.comparingInt(Product::getSold)).collect(Collectors.toList());
    }

    @Override
    public Map<String, String> descData(Product product) {
        Map<String, String> data = new HashMap<>();
        if (product.getCategory().getId() == 1) {
            Phone phone = phoneRepository.getPhoneById(product.getId());
            data.put("Card slot", phone.getRAM_slot() ? "yes" : "no");
            data.put("Built-in memory", phone.getBuilt_in_memory());
            data.put("Cores", phone.getCores().toString());
            data.put("Processor", phone.getCPU());
            data.put("Screen refresh", phone.getScreen_refresh().toString());
            data.put("OS", phone.getOs());
            data.put("Main camera", phone.getMain_camera());
            data.put("Front camera", phone.getFront_camera());
            data.put("NFC", phone.getNFC() ? "yes" : "no");
            data.put("Biometric security", phone.getBiometric_security() ? "yes" : "no");
            data.put("Wireless charger", phone.getWireless_charger() ? "yes" : "no");
            data.put("Capacity", phone.getBattery());
        } else if (product.getCategory().getId() == 2) {
            Laptop laptop = laptopRepository.getById(product.getId());
            data.put("Screen diagonal", laptop.getSc_diagonal());
            data.put("Matrix type", laptop.getMatrix_type());
            data.put("Screen resolution", laptop.getSc_resolution());
            data.put("Cores", laptop.getCores().toString());
            data.put("Processor series", laptop.getProcessor_series());
            data.put("Processor manufacturer", laptop.getProcessor_manufacturer());
            data.put("Storage", laptop.getStorage());
            data.put("Drive type", laptop.getDrive_type());
            data.put("Discrete graphics", laptop.getDiscrete_graphics());
            data.put("Video size", laptop.getVideo_size());
            data.put("Optical drive", laptop.getOptical_drive());
            data.put("Touch screen", laptop.getTouch_screen() ? "yes" : "no");
            data.put("Color", laptop.getColor());
            data.put("Weight", laptop.getWeight().toString());
            data.put("OS", laptop.getInst_os());
        } else if (product.getCategory().getId() == 3) {
            Watch watch = watchRepository.getById(product.getId());
            data.put("Purpose", watch.getPurpose());
            data.put("Waterproof", watch.getWaterproof() ? "yes" : "no");
            data.put("Touch screen", watch.getTouch_screen() ? "yes" : "no");
            data.put("Call support", watch.getCall_support() ? "yes" : "no");
            data.put("Music control", watch.getMusic_control() ? "yes" : "no");
            data.put("Pulse measurement", watch.getPulse_measurement() ? "yes" : "no");
            data.put("Sleep monitoring", watch.getSleep_monitoring() ? "yes" : "no");
            data.put("Display shape", watch.getDisplay_shape());
            data.put("Display diagonal", watch.getDisplay_diagonal());
            data.put("Color", watch.getColor());
            data.put("Working hours", watch.getWorking_hours());
        }
        return data;
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
