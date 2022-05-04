package com.example.shopjava.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class Filters {

    public Map<String, List<String>> phoneCharacteristics;

    public Map<String, List<String>> laptopCharacteristics;

    public Map<String, List<String>> watchCharacteristics;

    public Filters(){
        phoneCharacteristics = new LinkedHashMap<>();
        laptopCharacteristics = new LinkedHashMap<>();
        watchCharacteristics = new LinkedHashMap<>();
    }

    public void initPhoneChars(){
        List<String> brands = new ArrayList<>();
        brands.add("Apple");
        brands.add("Samsung");
        brands.add("Lenovo");
        brands.add("OPPO");
        brands.add("Poco");
        brands.add("Xiaomi");
        brands.add("Huawei");
        brands.add("realme");

        List<String> built_in_memory = new ArrayList<>();
        built_in_memory.add("up to 8 GB");
        built_in_memory.add("16 GB");
        built_in_memory.add("32 GB");
        built_in_memory.add("64 GB");
        built_in_memory.add("128 GB");
        built_in_memory.add("256 GB and more");

        List<String> os = new ArrayList<>();
        os.add("Android");
        os.add("iOS");

        phoneCharacteristics.put("Brand", brands);
        phoneCharacteristics.put("Built-in memory", built_in_memory);
        phoneCharacteristics.put("OS", os);
    }

    public void initLaptopChars() {
        List<String> brands = new ArrayList<>();
        brands.add("Apple");
        brands.add("Acer");
        brands.add("Lenovo");
        brands.add("Asus");
        brands.add("HP");
        brands.add("Dell");
        brands.add("Huawei");
        brands.add("MSI");

        List<String> deviceTypes = new ArrayList<>();
        deviceTypes.add("Gaming");
        deviceTypes.add("Ultra-thin");
        deviceTypes.add("Thin");
        deviceTypes.add("Transformer");

        List<String> processorManufacturers = new ArrayList<>();
        processorManufacturers.add("Intel");
        processorManufacturers.add("AMD");
        processorManufacturers.add("Apple processor");

        laptopCharacteristics.put("Brand", brands);
        laptopCharacteristics.put("Device type", deviceTypes);
        laptopCharacteristics.put("Processor manufacturer", processorManufacturers);
    }

    public void initWatchChars(){
        List<String> brands = new ArrayList<>();
        brands.add("Apple");
        brands.add("Samsung");
        brands.add("Amazfit");
        brands.add("Elari");
        brands.add("AgiGo");
        brands.add("Garmin");
        brands.add("2E");
        brands.add("Amico");

        List<String> displayForm = new ArrayList<>();
        displayForm.add("Square");
        displayForm.add("Circle");
        displayForm.add("Rectangular");

        List<String> touch_sc = new ArrayList<>();
        touch_sc.add("Yes");

        watchCharacteristics.put("Brand", brands);
        watchCharacteristics.put("Display form", displayForm);
        watchCharacteristics.put("Touch screen", touch_sc);
    }
}
