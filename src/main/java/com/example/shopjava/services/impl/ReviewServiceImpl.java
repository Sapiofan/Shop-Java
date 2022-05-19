package com.example.shopjava.services.impl;

import com.example.shopjava.entities.Review;
import com.example.shopjava.entities.User;
import com.example.shopjava.repos.ProductRepository;
import com.example.shopjava.repos.ReviewRepository;
import com.example.shopjava.repos.UserRepository;
import com.example.shopjava.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Page<Review> getAll(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum - 1, 5, Sort.by("date").descending());
        Page<Review> reviews = reviewRepository.findAll(pageable);
        return reviews;
    }

    @Override
    @Transactional
    public boolean addReview(Integer rating, String text, Boolean isRecommended, Authentication authentication, Long productId) {
        User user = userRepository.findByEmail(authentication.getName());
        List<Review> reviews = reviewRepository.findByUser(user.getId());
        for (Review review : reviews) {
            if (review.getProduct().getId().equals(productId)) {
                return true;
            }
        }
        Review review = new Review();
        review.setReview(text);
        review.setDate(Date.from(Instant.now()));
        review.setProduct(productRepository.findProductById(productId));
        review.setRating(rating);
        review.setRecommended(isRecommended);
        review.setUser(user);
        reviewRepository.save(review);
        return false;
    }

    @Override
    @Transactional
    public List<Review> findReviewsByProduct(Long productId) {
        List<Review> reviews = reviewRepository.findReviewsByProduct(productId);
        reviews.sort(Comparator.comparingLong(o -> o.getDate().getTime()));
        return reviews;
    }

    @Override
    @Transactional
    public List<Review> findReviewsByUser(String email) {
        return reviewRepository.findByUserEmail(email);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Integer calculateRecommended(List<Review> reviews) {
        int count = 0;
        for (Review review : reviews) {
            if (review.getRecommended())
                count++;
        }
        if (count == 0)
            return 0;
        return count * 100 / reviews.size();
    }
}
