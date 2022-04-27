package com.example.shopjava.repos;

import com.example.shopjava.entities.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FaqRepository extends JpaRepository<FAQ, Long> {
    @Query("select f from FAQ f where f.question = :question")
    FAQ findByQuestion(String question);
}
