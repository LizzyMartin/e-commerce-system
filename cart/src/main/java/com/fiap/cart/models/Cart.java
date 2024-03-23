package com.fiap.cart.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@Document(collection = "cart")
public class Cart {

    @Id
    private String id;
    private String userId;
    private Map<String, Integer> products;

    public Cart(String userId, Map<String, Integer> products) {
        this.userId = userId;
        this.products = products;
    }

    public void addProduct(String productId, int quantity) {
        this.products.put(productId, quantity);
    }
    
}
