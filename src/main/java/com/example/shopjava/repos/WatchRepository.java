package com.example.shopjava.repos;

import com.example.shopjava.entities.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WatchRepository extends JpaRepository<Watch, Long> {
    @Query("select w from Watch w")
    List<Watch> findAllWatches();
}
