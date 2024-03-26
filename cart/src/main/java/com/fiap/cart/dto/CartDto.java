package com.fiap.cart.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {

    @NotBlank
    private String userId;

    @NotBlank
    private String productId;

    @NotBlank
    private Integer quantity;
    
}
