package com.example.shopjava.repos;

import com.example.shopjava.entities.Phone;

import java.util.List;
import java.util.Set;

public interface FilterProducts {
    List<Phone> filterPhones(Set<String> series, Set<String> built_in_memory);
}
