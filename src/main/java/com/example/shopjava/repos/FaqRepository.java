package com.example.shopjava.repos;

import com.example.shopjava.entities.FAQ;
import com.example.shopjava.entities.contacts.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaqRepository extends JpaRepository<FAQ, Long> {
    @Query("select f from FAQ f where f.question = :question")
    FAQ findByQuestion(String question);

    @Query("delete from FAQ f where f.id=:id")
    @Modifying
    void deleteById(Long id);
    @Query("delete from FAQ f where f.question=:question")
    @Modifying
    void deleteByQuestion(String question);
}
