package com.restapi.response;

import com.restapi.model.ArtWork;
import com.restapi.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
   private Long id;
   private Long userId;
   private String title;
   private  Double price;
   private  Long artworkId;

}
