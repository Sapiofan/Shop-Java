package com.example.shopjava.services;

import com.example.shopjava.entities.contacts.Contact;

import java.util.List;

public interface ContactService {
    String addContactMessage(Contact contact, String subject, String message);

    String subs(String email);

    List<Contact> contacts();

    void deleteById(Long id);

    void deleteByEmail(String email);
}
