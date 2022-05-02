package com.example.shopjava.repos.impl;

import com.example.shopjava.entities.Phone;
import com.example.shopjava.repos.Utils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UtilsImpl implements Utils {
    @Override
    public Phone min(List<Phone> phoneList) {
        return phoneList.stream().min(Comparator.comparingDouble(Phone::getPrice)).get();
    }

    @Override
    public Phone max(List<Phone> phones) {
        return phones.stream().max(Comparator.comparingDouble(Phone::getPrice)).get();
    }
}
