package com.restapi.service;

import com.restapi.dto.CartDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.ArtWork;
import com.restapi.model.Cart;
import com.restapi.repository.ArtWorkRepository;
import com.restapi.repository.CartRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.CartRequest;
import com.restapi.response.CartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArtWorkRepository artWorkRepository;
    @Autowired
    private CartDto cartDto;

    @Transactional
    public List<CartResponse> addToCart(CartRequest cartRequest) {
        AppUser appUser = userRepository.findById(cartRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", cartRequest.getUserId()));//userid

        ArtWork artWork = artWorkRepository.findById(cartRequest.getArtWorkId())
                .orElseThrow(() -> new ResourceNotFoundException("artworkId", "artworkId", cartRequest.getArtWorkId()));//productid

        Optional<List<Cart>> cartOptional = cartRepository.findUserCart(cartRequest.getUserId());//for query

        //checking cart present
        if (cartOptional.isPresent()) {
            boolean ispresent = false;
            for (Cart cart : cartOptional.get()) {
                if ((cart.getArtWork().getId()) == cartRequest.getArtWorkId()) {
                    cart.setCount(cartRequest.getCount());//set count
                    cart.setTotal(cartRequest.getTotal());
                    cartRepository.save(cart);
                    ispresent = true;

                }
            }
            //cart not present
            if (!ispresent) {
                Cart cart = new Cart();
                cart.setAppUser(appUser);
                cart.setArtWork(artWork);
                cart.setCount(cartRequest.getCount());
                cart.setTotal(cartRequest.getTotal());
                cartRepository.save(cart);
            }
        } else {
            Cart cart = new Cart();
            cart.setAppUser(appUser);
            cart.setArtWork(artWork);
            cart.setCount(cartRequest.getCount());
            cart.setTotal(cartRequest.getTotal());
            cartRepository.save(cart);
        }
        return findUserCart(cartRequest.getUserId());
    }

    public List<CartResponse> findUserCart(Long userId) {
        List<Cart> cart=cartRepository.findUserCart(userId).orElseThrow(()->new ResourceNotFoundException("userId","userId",userId));
        return  cartDto.mapToCart(cart);
    }

    public List<CartResponse> deleteArtWorkFromCart(Long userId, Long artWorkId) {
        cartRepository.deleteById(artWorkId);
        return findUserCart(userId);
    }


    public List<CartResponse> updateCart(CartRequest cartRequest) {
        AppUser appUser = userRepository.findById(cartRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", cartRequest.getUserId()));//userid

        ArtWork artWork = artWorkRepository.findById(cartRequest.getArtWorkId())
                .orElseThrow(() -> new ResourceNotFoundException("artworkId", "artworkId", cartRequest.getArtWorkId()));//productid

        Optional<List<Cart>> cartOptional = cartRepository.findUserCart(cartRequest.getUserId());//for query

        //checking cart present
        if (cartOptional.isPresent()) {
            boolean ispresent = false;
            for (Cart cart : cartOptional.get()) {
                if ((cart.getArtWork().getId()) == cartRequest.getArtWorkId()) {
                    cart.setCount(cartRequest.getCount());//set count
                    cart.setTotal(cartRequest.getTotal());
                    cartRepository.save(cart);
                    ispresent = true;

                }
            }
            //cart not present
            if (!ispresent) {
                Cart cart = new Cart();
                cart.setAppUser(appUser);
                cart.setArtWork(artWork);
                cart.setCount(cartRequest.getCount());
                cart.setTotal(cartRequest.getTotal());
                cartRepository.save(cart);
            }
        } else {
            Cart cart = new Cart();
            cart.setAppUser(appUser);
            cart.setArtWork(artWork);
            cart.setCount(cartRequest.getCount());
            cart.setTotal(cartRequest.getTotal());
            cartRepository.save(cart);
        }
        return findUserCart(cartRequest.getUserId());
    }
}
