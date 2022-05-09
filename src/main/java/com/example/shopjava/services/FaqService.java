package com.example.shopjava.services;

import com.example.shopjava.entities.FAQ;

import java.util.List;

public interface FaqService {
    String addFaq(FAQ faq);
    List<FAQ> getFaqs();

    void deleteById(Long id);
    void deleteByQuestion(String question);
}
