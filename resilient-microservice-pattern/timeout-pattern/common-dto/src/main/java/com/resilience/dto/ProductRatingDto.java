package com.resilience.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@ToString
@Getter
@Setter
public class ProductRatingDto {

    private double avgRating;
    private List<ReviewDto> reviews;

}
