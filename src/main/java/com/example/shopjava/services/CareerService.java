package com.example.shopjava.services;


import com.example.shopjava.entities.Career;

import java.util.List;

public interface CareerService {
    String addCareerUser(Career career);

    List<Career> getCareers();

    void deleteCareerUserById(Long id);

    void deleteCareerUserByEmail(String email);
}
