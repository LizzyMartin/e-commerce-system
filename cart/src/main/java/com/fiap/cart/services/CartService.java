package com.fiap.cart.services;

import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.fiap.cart.models.Cart;
import com.fiap.cart.repositories.CartRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart findByUserId(String id) {
        return cartRepository.findByUserId(id).orElse(null);
    }

    public Cart addProductToCart(String userId, String productId, int quantity) {
        Cart cart = cartRepository.findByUserId(userId).orElse(new Cart(userId, new HashMap<>()));
        cart.addProduct(productId, quantity);
        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(String userId, String productId) {
        var cart = cartRepository.findByUserId(userId).orElse(null);
        if (cart == null) {
            return null;
        }
        cart.getProducts().remove(productId);
        return cartRepository.save(cart);
    }

}
