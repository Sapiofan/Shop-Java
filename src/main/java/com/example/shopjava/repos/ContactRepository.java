package com.example.shopjava.repos;

import com.example.shopjava.entities.contacts.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT c from Contact c where c.email = :email")
    Contact findByEmail(String email);
}
