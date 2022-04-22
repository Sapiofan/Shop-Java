package com.example.shopjava.repos;

import com.example.shopjava.entities.Cart;
import com.example.shopjava.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    @Query("SELECT f FROM Favorite f WHERE f.user.id = :userId")
    Cart findCartByUser(Long userId);
}
