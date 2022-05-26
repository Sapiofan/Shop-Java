package com.example.shopjava.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Filters {

    public Map<String, List<String>> phoneCharacteristics;

    public Map<String, List<String>> descriptionTable;

    public Map<String, List<String>> laptopCharacteristics;

    public Map<String, List<String>> watchCharacteristics;

    public Filters() {
        phoneCharacteristics = new LinkedHashMap<>();
        descriptionTable = new LinkedHashMap<>();
        laptopCharacteristics = new LinkedHashMap<>();
        watchCharacteristics = new LinkedHashMap<>();
    }

    public void initPhoneChars() {
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

        List<String> series = new ArrayList<>();
        series.add("Some series");

        List<String> os = new ArrayList<>();
        os.add("Android");
        os.add("iOS");

        List<String> ram_slot = new ArrayList<>();
        ram_slot.add("Yes");
        ram_slot.add("No");

        List<String> cpu = new ArrayList<>();
        cpu.add("Apple cpu");
        cpu.add("Exynos");
        cpu.add("MediaTek");
        cpu.add("UNISOC");

        List<String> wireless_charger = new ArrayList<>();
        wireless_charger.add("Yes");
        wireless_charger.add("No");

        List<String> nfc = new ArrayList<>();
        nfc.add("Yes");
        nfc.add("No");

        List<String> screen_diagonal = new ArrayList<>();
        screen_diagonal.add("7 and more");
        screen_diagonal.add("6.5-6.9");
        screen_diagonal.add("6-6.4");
        screen_diagonal.add("5-5.9");

        List<String> biometric_security = new ArrayList<>();
        biometric_security.add("face recognition");
        biometric_security.add("fingerprint scanner");

        List<String> cores = new ArrayList<>();
        cores.add("2");
        cores.add("4");
        cores.add("6");
        cores.add("8");

        List<String> screen_refresh = new ArrayList<>();
        screen_refresh.add("30");
        screen_refresh.add("60");

        phoneCharacteristics.put("Brand", brands);
        phoneCharacteristics.put("Built-in memory", built_in_memory);
        phoneCharacteristics.put("OS", os);
        phoneCharacteristics.put("RAM slot", ram_slot);
        phoneCharacteristics.put("CPU", cpu);
        phoneCharacteristics.put("Screen diagonal", screen_diagonal);
        phoneCharacteristics.put("Biometric security", biometric_security);
        phoneCharacteristics.put("Cores", cores);
        phoneCharacteristics.put("Wireless charger", wireless_charger);
        phoneCharacteristics.put("NFC", nfc);
        phoneCharacteristics.put("Series", series);
        phoneCharacteristics.put("Screen refresh", screen_refresh);

        List<String> memory = new ArrayList<>();
        memory.add("RAM");
        memory.add("Card slot");
        memory.add("Built-in memory");

        List<String> processor = new ArrayList<>();
        processor.add("Cores");
        processor.add("Processor");
        processor.add("Screen refresh");

        List<String> OS = new ArrayList<>();
        OS.add("OS");

        descriptionTable.put("Memory", memory);
        descriptionTable.put("Processor", processor);
        descriptionTable.put("OS", OS);
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

        List<String> sc_diagonals = new ArrayList<>();
        sc_diagonals.add("13-13.9");
        sc_diagonals.add("14");
        sc_diagonals.add("15-15.6");
        sc_diagonals.add("16.2 and more");

        List<String> cores = new ArrayList<>();
        cores.add("12");
        cores.add("10");
        cores.add("8");
        cores.add("6");
        cores.add("4");
        cores.add("2");

        List<String> processor_series = new ArrayList<>();
        processor_series.add("Apple M1");
        processor_series.add("Apple M1 Pro");
        processor_series.add("Intel i9");
        processor_series.add("Intel i7");
        processor_series.add("Intel i5");
        processor_series.add("AMD Ryzen 9");
        processor_series.add("AMD Ryzen 7");
        processor_series.add("AMD Ryzen 5");
        processor_series.add("AMD Ryzen 3");

        List<String> ram = new ArrayList<>();
        ram.add("4 GB");
        ram.add("8 GB");
        ram.add("16 GB");
        ram.add("32 GB");
        ram.add("64 GB");

        List<String> drive_type = new ArrayList<>();
        drive_type.add("HDD");
        drive_type.add("SDD");
        drive_type.add("HDD + SDD");
        drive_type.add("eMMC");

        List<String> discrete_graphics = new ArrayList<>();
        discrete_graphics.add("GeForce MX130");
        discrete_graphics.add("GeForce MX330");
        discrete_graphics.add("GeForce MX350");
        discrete_graphics.add("GeForce MX450");
        discrete_graphics.add("GeForce GTX1050");
        discrete_graphics.add("GeForce GTX1650");
        discrete_graphics.add("GeForce GTX1660Ti");

        List<String> series = new ArrayList<>();
        series.add("someSeries");

        List<String> inst_os = new ArrayList<>();
        inst_os.add("Windows 11 Pro");
        inst_os.add("Windows 11 Home");
        inst_os.add("Windows 10 Pro");
        inst_os.add("Windows 10 Home");
        inst_os.add("Mac OS");
        inst_os.add("Without OS");

        List<String> storage = new ArrayList<>();
        storage.add("Up to 320 GB");
        storage.add("500 GB");
        storage.add("1 TB");
        storage.add("More than 1 TB");

        List<String> screen_refresh = new ArrayList<>();
        screen_refresh.add("60");
        screen_refresh.add("90");
        screen_refresh.add("120");
        screen_refresh.add("144");
        screen_refresh.add("240");

        List<String> color = new ArrayList<>();
        color.add("Gray");
        color.add("Gold");
        color.add("Silver");
        color.add("White");

        List<String> video_size = new ArrayList<>();
        video_size.add("2 GB");
        video_size.add("4 GB");
        video_size.add("6 GB");
        video_size.add("8 GB");
        video_size.add("12 GB");

        laptopCharacteristics.put("Brand", brands);
        laptopCharacteristics.put("Screen diagonal", sc_diagonals);
        laptopCharacteristics.put("Device type", deviceTypes);
        laptopCharacteristics.put("RAM", ram);
        laptopCharacteristics.put("Cores", cores);
        laptopCharacteristics.put("Processor series", processor_series);
        laptopCharacteristics.put("Drive type", drive_type);
        laptopCharacteristics.put("Discrete graphics", discrete_graphics);
        laptopCharacteristics.put("Series", series);
        laptopCharacteristics.put("Installed OS", inst_os);
        laptopCharacteristics.put("Storage", storage);
        laptopCharacteristics.put("Screen refresh", screen_refresh);
        laptopCharacteristics.put("Color", color);
        laptopCharacteristics.put("Video size", video_size);
        laptopCharacteristics.put("Processor manufacturer", processorManufacturers);
    }

    public void initWatchChars() {
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
        touch_sc.add("No");

        List<String> shape = new ArrayList<>();
        shape.add("Square");
        shape.add("Circle");
        shape.add("Rectangle");

        List<String> waterproof = new ArrayList<>();
        waterproof.add("Yes");
        waterproof.add("No");

        List<String> call_support = new ArrayList<>();
        call_support.add("Yes");
        call_support.add("No");

        List<String> music_control = new ArrayList<>();
        music_control.add("Yes");
        music_control.add("No");

        List<String> pulse_measurement = new ArrayList<>();
        pulse_measurement.add("Yes");
        pulse_measurement.add("No");

        List<String> step_counting = new ArrayList<>();
        step_counting.add("Yes");
        step_counting.add("No");

        List<String> sleep_monitoring = new ArrayList<>();
        sleep_monitoring.add("Yes");
        sleep_monitoring.add("No");

        List<String> color = new ArrayList<>();
        color.add("Black");
        color.add("White");
        color.add("Purple");
        color.add("Red");
        color.add("Blue");
        color.add("Green");
        color.add("Gold");
        color.add("Gray");
        color.add("Silver");

        List<String> working_hours = new ArrayList<>();
        working_hours.add("Up to 18 hours");
        working_hours.add("Up to 24 hours");
        working_hours.add("Up to 2 days");
        working_hours.add("Up to 3 days");
        working_hours.add("Up to 4 days");
        working_hours.add("Up to 7 days");
        working_hours.add("Up to 10 days");

        List<String> display_diagonal = new ArrayList<>();
        display_diagonal.add("29.3 mm");
        display_diagonal.add("31 mm");
        display_diagonal.add("33 mm");
        display_diagonal.add("35.4 mm");
        display_diagonal.add("38 mm");
        display_diagonal.add("39 mm");

        watchCharacteristics.put("Brand", brands);
        watchCharacteristics.put("Shape", shape);
        watchCharacteristics.put("Waterproof", waterproof);
        watchCharacteristics.put("Call support", call_support);
        watchCharacteristics.put("Music control", music_control);
        watchCharacteristics.put("Pulse measurement", pulse_measurement);
        watchCharacteristics.put("Step counting", step_counting);
        watchCharacteristics.put("Sleep monitoring", sleep_monitoring);
        watchCharacteristics.put("Color", color);
        watchCharacteristics.put("Working hours", working_hours);
        watchCharacteristics.put("Display diagonal", display_diagonal);
        watchCharacteristics.put("Touch screen", touch_sc); // purpose
    }
}
