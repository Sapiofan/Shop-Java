package com.example.shopjava.repos;


import com.example.shopjava.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p where p.name LIKE %?1%" +
            " or p.brand LIKE %?1%")
    List<Product> searchProducts(String keyword);
}
