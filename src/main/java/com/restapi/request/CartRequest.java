package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    @NotNull(message = "Artwork ID cannot be null")
    private Long artWorkId;

    @NotNull(message = "Count cannot be null")
    @Positive(message = "Count should be a positive number")
    private Integer count;

    @NotNull(message = "User ID cannot be null")
    private Long userId;
}
