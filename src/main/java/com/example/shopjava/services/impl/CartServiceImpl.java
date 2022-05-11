package com.example.shopjava.services.impl;

import com.example.shopjava.entities.Cart;
import com.example.shopjava.entities.Product;
import com.example.shopjava.repos.CartRepository;
import com.example.shopjava.repos.ProductRepository;
import com.example.shopjava.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Set;

public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Cart addProduct(Cart cart, Long productId) {
        cart.getProducts().add(productRepository.findProductById(productId));
        cartRepository.save(cart);
        return cart;
    }

    @Override
    @Transactional
    public Cart getUserProducts(Long id) {
        return cartRepository.findProductsByUser(id);
    }

    @Override
    @Transactional
    public Cart deleteProduct(Cart cart, Long productId) {
        Set<Product> products = cart.getProducts();
        products.removeIf(product -> productId.equals(product.getId()));
        cartRepository.save(cart);
        return cart;
    }
}
