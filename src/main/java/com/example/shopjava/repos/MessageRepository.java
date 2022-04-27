package com.example.shopjava.repos;

import com.example.shopjava.entities.contacts.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
