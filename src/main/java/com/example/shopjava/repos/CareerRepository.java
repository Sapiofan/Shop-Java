package com.example.shopjava.repos;

import com.example.shopjava.entities.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CareerRepository extends JpaRepository<Career, Long> {
    @Query("SELECT c from Career c where c.email = :email")
    Career findByEmail(String email);
}
