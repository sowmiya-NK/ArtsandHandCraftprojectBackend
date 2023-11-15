package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtWorkRequest {
    private Long id;
    private  String title;
    private  String description;
    private  Double price;
    private  byte[] photo;
   private Long categoryId;
}
