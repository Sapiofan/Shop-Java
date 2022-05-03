package com.example.shopjava.repos;

import com.example.shopjava.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    @Override
    List<Laptop> findAll();
}
