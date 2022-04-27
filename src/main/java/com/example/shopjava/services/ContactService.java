package com.example.shopjava.services;

import com.example.shopjava.entities.contacts.Contact;

public interface ContactService {
    String addContactMessage(Contact contact, String subject, String message);
    String subs(String email);
}
