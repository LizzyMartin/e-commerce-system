package com.fiap.cart.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fiap.cart.dto.CartDto;
import com.fiap.cart.models.Cart;
import com.fiap.cart.services.CartService;


@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public Cart findByUserId(@PathVariable String userId) {
        return cartService.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<String> addProductToCart(Authentication authentication, @RequestBody CartDto cart) {
        if (authentication.getName().equals("admin")) {
            return ResponseEntity.status(403).body("Forbidden");
        }

        cartService.addProductToCart(cart.getUserId(), cart.getProductId(), cart.getQuantity());
        return ResponseEntity.ok("Product added to cart");
    }

    @DeleteMapping
    public ResponseEntity<String> removeProductFromCart(Authentication authentication, @RequestBody CartDto cart) {
        if (authentication.getName().equals("admin")) {
            return ResponseEntity.status(403).body("Forbidden");
        }

        cartService.removeProductFromCart(cart.getUserId(), cart.getProductId());
        return ResponseEntity.ok("Product removed from cart");
    }

}
