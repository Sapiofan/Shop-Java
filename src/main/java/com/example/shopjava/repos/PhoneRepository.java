package com.example.shopjava.repos;

import com.example.shopjava.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query("select p from Phone p")
    List<Phone> findAll();
}
