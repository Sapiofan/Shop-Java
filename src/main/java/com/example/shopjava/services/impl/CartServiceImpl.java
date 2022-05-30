package com.example.shopjava.services.impl;

import com.example.shopjava.controllers.MyController;
import com.example.shopjava.entities.Cart;
import com.example.shopjava.entities.CartProduct;
import com.example.shopjava.entities.Product;
import com.example.shopjava.repos.CartProductRepo;
import com.example.shopjava.repos.CartRepository;
import com.example.shopjava.repos.ProductRepository;
import com.example.shopjava.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartProductRepo cartProductRepo;

    private static final Logger log = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    @Transactional
    public Cart addProduct(Cart cart, Long productId) {
        Product product = productRepository.findProductById(productId);
        CartProduct cartProduct = new CartProduct(cart, product, 1, product.getPrice());
        cartProductRepo.save(cartProduct);
        cart.setTotalPrice(cartProduct.getTotal()+product.getPrice());
        cartRepository.save(cart);
        return cart;
    }

    @Override
    @Transactional
    public void increaseQuantity(Long productId, Cart cart) {
        CartProduct cartProduct = cartProductRepo.findCartProduct(productId, cart.getId());
        Integer productPrice = cartProduct.getTotal() / cartProduct.getQuantity();
        cartProduct.setTotal(cartProduct.getTotal() + productPrice);
        cartProduct.setQuantity(cartProduct.getQuantity() + 1);
        cart.setTotalPrice(cartProduct.getTotal()+productPrice);
        cartRepository.save(cart);
        cartProductRepo.save(cartProduct);
    }

    @Override
    @Transactional
    public void decreaseQuantity(Long productId, Cart cart) {
        CartProduct cartProduct = cartProductRepo.findCartProduct(productId, cart.getId());
        if(cartProduct.getQuantity() > 1){
            Integer productPrice = cartProduct.getTotal() / cartProduct.getQuantity();
            cartProduct.setTotal(cartProduct.getTotal() - productPrice);
            cartProduct.setQuantity(cartProduct.getQuantity() - 1);
            cart.setTotalPrice(cartProduct.getTotal()-productPrice);
            cartRepository.save(cart);
        }
        cartProductRepo.save(cartProduct);
    }

    @Override
    @Transactional
    public Cart getUserProducts(Long id) {
        return cartRepository.findProductsByUser(id);
    }

    @Override
    @Transactional
    public void deleteProduct(Cart cart, Long productId) {
        cartProductRepo.deleteCartProduct(productId, cart.getId());
    }
}
