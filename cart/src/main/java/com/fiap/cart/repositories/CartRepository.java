package com.fiap.cart.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fiap.cart.models.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String>{

    Optional<Cart> findByUserId(String userId);
    
}
