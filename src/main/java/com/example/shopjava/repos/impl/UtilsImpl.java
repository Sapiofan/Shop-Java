package com.example.shopjava.repos.impl;

import com.example.shopjava.entities.Laptop;
import com.example.shopjava.entities.Phone;
import com.example.shopjava.entities.Watch;
import com.example.shopjava.repos.Utils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UtilsImpl implements Utils {
    @Override
    public Phone min(List<Phone> phoneList) {
        if (!phoneList.isEmpty())
            return phoneList.stream().min(Comparator.comparingDouble(Phone::getPrice)).get();
        return null;
    }

    @Override
    public Phone max(List<Phone> phones) {
        if (!phones.isEmpty())
            return phones.stream().max(Comparator.comparingDouble(Phone::getPrice)).get();
        return null;
    }

    @Override
    public Laptop maxLaptop(List<Laptop> laptops) {
        if (!laptops.isEmpty())
            return laptops.stream().max(Comparator.comparingDouble(Laptop::getPrice)).get();
        return null;
    }

    @Override
    public Watch maxWatch(List<Watch> watches) {
        if (!watches.isEmpty())
            return watches.stream().max(Comparator.comparingDouble(Watch::getPrice)).get();
        return null;
    }

    @Override
    public boolean checkAuth(Authentication authentication) {
        return authentication != null && !authentication.getName().equals("anonymousUser");
    }

}
