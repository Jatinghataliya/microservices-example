package com.resilience.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor(staticName = "of")
@Setter
@Getter
public class Product {

    private int productId;
    private String description;
    private double price;

}
