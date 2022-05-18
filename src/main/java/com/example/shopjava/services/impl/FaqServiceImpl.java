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
        if (dbFaq != null) {
            return "Such question has already added";
        }
        faqRepository.save(faq);
        return "Question was added";
    }

    @Override
    @Transactional
    public String editFaq(Long id, String question, String answer) {
        FAQ dbFaq = faqRepository.findFaqById(id);
        if(dbFaq != null){
            dbFaq.setQuestion(question);
            dbFaq.setAnswer(answer);
            faqRepository.save(dbFaq);
            return "Was successfully edited";
        }
        return "Something went wrong. Such faq doesn't exist.";
    }

    @Override
    @Transactional
    public List<FAQ> getFaqs() {
        return faqRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        faqRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByQuestion(String question) {
        faqRepository.deleteByQuestion(question);
    }
}
