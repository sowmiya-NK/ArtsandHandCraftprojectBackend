package com.restapi.service;

import com.restapi.dto.OrderDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.*;
import com.restapi.repository.*;
import com.restapi.request.OrderRequest;
import com.restapi.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDto orderDto;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderArtWorkRepository orderArtWorkRepository;

    @Autowired
    private ArtWorkRepository artWorkRepository;
    public List<OrderResponse> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderDto.mapToOrderResponse(orderList);

    }

    public List<OrderResponse> getUserOrders(Long userId) {
        List<Order> orderList = orderRepository.findUserOrder(userId).orElseThrow(() -> new ResourceNotFoundException("userId", "UserId", userId));
        //System.out.println(orderList.size());
        return orderDto.mapToOrderResponse(orderList);
    }


    public List<OrderResponse> updateOrderStatus(Long orderId, Long statusId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("orderId", "orderId", orderId));

        OrderStatus orderStatus = orderStatusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException("statusId", "statusId", statusId));

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return getAllOrders();
    }

    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusRepository.findAll();
    }


    //userId,addressId,cartId,statusId
    public List<OrderResponse> placeOrder(Long userId, Long addressId) {
        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("addressId", "addressId", addressId));

        List<Cart> cartList = cartRepository.findUserCart(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));

        OrderStatus orderStatus = orderStatusRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("statusId", "statusId", 1));//1l long datatype

        Order order = new Order();
        order.setAppUser(appUser);
        order.setAddress(address);
        order.setOrderStatus(orderStatus);


        for (Cart cart : cartList) {
            OrderedArtWork orderedArtWork = new OrderedArtWork();
            orderedArtWork.setTitle(cart.getArtWork().getTitle());
            orderedArtWork.setDescription(cart.getArtWork().getDescription());
            orderedArtWork.setPrice(cart.getArtWork().getPrice());
            orderedArtWork.setCount(cart.getCount());

            orderArtWorkRepository.save(orderedArtWork);
            cartRepository.delete(cart);//after place order cart should be removed
        }
        List<OrderedArtWork> orderedArtWorks = orderArtWorkRepository.findAll();
        order.setOrderedArtWorkList(orderedArtWorks);
        orderRepository.save(order);
        return getUserOrders(userId);


    }

    public List<OrderResponse> deleteOrder(Long userId) {
        orderRepository.deleteById(userId);
        return getAllOrders();
    }
}
