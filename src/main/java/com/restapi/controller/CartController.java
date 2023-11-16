package com.restapi.controller;

import com.restapi.model.Cart;
import com.restapi.model.Role;
import com.restapi.request.CartRequest;
import com.restapi.response.CartResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RolesAllowed(Role.USER)
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    private ResponseEntity<APIResponse> addToCart(@Valid  @RequestBody CartRequest cartRequest) {
        List<CartResponse> cartResponseList = cartService.addToCart(cartRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cartResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{userId}/{artWorkId}")
    private ResponseEntity<APIResponse> deleteArtWorkFromCart(@PathVariable Long userId, @PathVariable Long artWorkId) {
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cartService.deleteArtWorkFromCart(userId, artWorkId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    private ResponseEntity<APIResponse> getUserCart(@PathVariable Long userId) {
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cartService.findUserCart(userId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
