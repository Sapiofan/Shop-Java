package com.example.shopjava.repos;

import com.example.shopjava.entities.Laptop;
import com.example.shopjava.entities.Phone;

import java.util.List;

public interface Utils {
    Phone min(List<Phone> phoneList);
    Phone max(List<Phone> phones);
    Laptop maxLaptop(List<Laptop> laptops);
}
