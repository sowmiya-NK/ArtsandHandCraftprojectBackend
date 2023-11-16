package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtWorkRequest {
    private Long id;

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 3, message = "Title should have at least 3 characters")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 3, message = "Description should have at least 3 characters")
    private String description;

    @NotNull(message = "Price cannot be null")
    private Double price;

    private byte[] photo;

    @NotNull(message = "Category ID cannot be null")
    private Long categoryId;
}
