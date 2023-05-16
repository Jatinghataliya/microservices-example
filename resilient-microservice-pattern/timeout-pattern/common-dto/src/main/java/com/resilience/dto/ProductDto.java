package com.resilience.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Setter
@Getter
public class ProductDto {

    private int productId;
    private String description;
    private double price;
    private ProductRatingDto productRating;

}
