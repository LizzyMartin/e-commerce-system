package com.fiap.cart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

    private String userId;
    private String productId;
    private int quantity;
    
}
