package com.example.shopjava.repos;

import com.example.shopjava.entities.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {
    @Query("SELECT c from Career c where c.email = :email")
    Career findByEmail(String email);

    @Query("delete from Career c where c.id=:id")
    @Modifying
    void deleteById(Long id);

    @Query("delete from Career c where c.email=:email")
    @Modifying
    void deleteByEmail(String email);
}
