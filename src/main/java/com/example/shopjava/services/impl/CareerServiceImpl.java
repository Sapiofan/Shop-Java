package com.example.shopjava.services.impl;

import com.example.shopjava.entities.Career;
import com.example.shopjava.repos.CareerRepository;
import com.example.shopjava.services.CareerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CareerServiceImpl implements CareerService {

    @Autowired
    private CareerRepository careerRepository;

    private static final Logger log = LoggerFactory.getLogger("log");

    @Override
    @Transactional
    public String addCareerUser(Career career) {
        if(careerRepository.findByEmail(career.getEmail()) != null){
            log.warn("Such career user exist: " + career.getEmail());
            return "Sorry, but user with such email has already send request for job";
        }
        careerRepository.save(career);
        log.info("New career user was successfully added: " + career.getEmail());
        return "Your request for job was successfully sent. Expect an email in 2-3 days";
    }

    @Override
    @Transactional
    public List<Career> getCareers() {
        return careerRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCareerUserById(Long id) {
        careerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCareerUserByEmail(String email) {
        careerRepository.deleteByEmail(email);
    }
}
