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
    @NotEmpty
    @Size(min = 3, message = "title should have at least 3 characters")
    private  String title;

    @NotEmpty
    @Size(min = 3, message = "description should have at least 3 characters")
    private  String description;

    private  Double price;
    private  byte[] photo;
   private Long categoryId;
}
