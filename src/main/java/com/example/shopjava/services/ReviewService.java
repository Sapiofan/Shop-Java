package com.example.shopjava.services;

import com.example.shopjava.entities.Review;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ReviewService {
    boolean addReview(Integer rating, String text, Boolean isRecommended, Authentication authentication, Long productId);

    List<Review> findReviewsByProduct(Long productId);

    List<Review> findReviewsByUser(Long userId);

    Integer calculateRecommended(List<Review> reviews);
}
