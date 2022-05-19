package com.example.shopjava.services;


import com.example.shopjava.entities.Career;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CareerService {
    String addCareerUser(Career career);

    Page<Career> getCareers(int pageNum);

    void deleteCareerUserById(Long id);

    void deleteCareerUserByEmail(String email);
}
