package com.example.shopjava.repos;

import com.example.shopjava.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.product.id = :productId")
    List<Review> findReviewsByProduct(Long productId);
}
