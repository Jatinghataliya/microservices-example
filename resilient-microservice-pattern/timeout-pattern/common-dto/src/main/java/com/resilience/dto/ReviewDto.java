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
public class ReviewDto {

    private String userFirstname;
    private String userLastname;
    private int productId;
    private int rating;
    private String comment;

}
