package com.example.shopjava.services.impl;

import com.example.shopjava.entities.FAQ;
import com.example.shopjava.repos.FaqRepository;
import com.example.shopjava.services.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqRepository faqRepository;

    @Override
    @Transactional
    public String addFaq(FAQ faq) {
        FAQ dbFaq = faqRepository.findByQuestion(faq.getQuestion());
        if(dbFaq != null){
            return "Such question has already added";
        }
        faqRepository.save(faq);
        return "Question was added";
    }

    @Override
    @Transactional
    public List<FAQ> getFaqs() {
        return faqRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        faqRepository.deleteById(id);
    }

    @Override
    public void deleteByQuestion(String question) {
        faqRepository.deleteByQuestion(question);
    }
}
