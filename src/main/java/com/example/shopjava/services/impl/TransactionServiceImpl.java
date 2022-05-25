package com.example.shopjava.services.impl;

import com.example.shopjava.entities.Transaction;
import com.example.shopjava.repos.TransactionRepository;
import com.example.shopjava.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public Transaction addNewTransaction(String name, String phone, String email, String city, String card, String date, String cvv, Integer total) {
        Transaction transaction = new Transaction(total, "Privat24", email, phone, city, name);
        transactionRepository.save(transaction);
        return transaction;
    }
}
