package com.example.shopjava.repos;

import com.example.shopjava.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.product.id = :productId")
    List<Review> findReviewsByProduct(Long productId);

    @Query("SELECT r FROM Review r WHERE r.user.id = :userId")
    List<Review> findByUser(Long userId);

    @Query("delete from Review r where r.id=:id")
    @Modifying
    void deleteById(Long id);
}
