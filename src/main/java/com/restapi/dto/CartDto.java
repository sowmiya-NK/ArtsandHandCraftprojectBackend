package com.restapi.dto;

import com.restapi.model.Cart;
import com.restapi.response.CartResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartDto {

    public List<CartResponse> mapToCart(List<Cart> cart) {
        List<CartResponse> cartResponseList = new ArrayList<>();

        for (Cart cart1 : cart) {
            CartResponse cartResponse = new CartResponse();
            cartResponse.setId(cart1.getId());
            cartResponse.setUserId(cart1.getAppUser().getId());
            cartResponse.setTitle(cart1.getArtWork().getTitle());
            cartResponse.setPrice(cart1.getArtWork().getPrice());
            cartResponse.setArtworkId(cart1.getArtWork().getId());
            cartResponse.setCount(cart1.getCount());
            cartResponse.setTotal(cart1.getTotal());
            cartResponseList.add(cartResponse);

        }

        return cartResponseList;
    }
}
