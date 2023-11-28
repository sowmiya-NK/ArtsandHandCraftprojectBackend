package com.restapi.dto;

import com.restapi.model.Order;
import com.restapi.model.OrderedArtWork;
import com.restapi.repository.OrderArtWorkRepository;
import com.restapi.request.OrderRequest;
import com.restapi.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDto {
    @Autowired
    private OrderArtWorkRepository orderArtWorkRepository;

    public List<OrderResponse> mapToOrderResponse(List<Order> orderList) {
        List<OrderResponse> orderResponseList = new ArrayList<>();
        OrderRequest orderRequest = new OrderRequest();
        //Order order1 = new Order();
        for (Order order : orderList) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(order.getId());
            orderResponse.setUserId(order.getAppUser().getId());
            orderResponse.setUsername(order.getAppUser().getUsername());
            orderResponse.setOrderStatus(order.getOrderStatus().getStatus());
            orderResponse.setAddress(order.getAddress());
            orderResponse.setTotal(orderResponse.getTotal());
            List<OrderedArtWork> orderedArtWorks = orderArtWorkRepository.findAll();
            orderResponse.setOrderedArtWorkList(orderedArtWorks);
            orderResponseList.add(orderResponse);

        }
        return orderResponseList;
    }

    public List<OrderResponse> mapToOrder(List<Order> orderList, Long userId) {
        List<OrderResponse> orderResponseList = new ArrayList<>();
        OrderRequest orderRequest = new OrderRequest();

        for (Order order : orderList) {
            // Check if the order belongs to the specified user
            if (order.getAppUser().getId().equals(userId)) {
                OrderResponse orderResponse = new OrderResponse();
                orderResponse.setId(order.getId());
                orderResponse.setUserId(order.getAppUser().getId());
                orderResponse.setUsername(order.getAppUser().getUsername());
                orderResponse.setOrderStatus(order.getOrderStatus().getStatus());

                orderResponse.setAddress(order.getAddress());

                // Assuming you want to get ordered artworks specific to this order
                List<OrderedArtWork> orderedArtWorks = orderArtWorkRepository.findByOrderId(order.getId());
                orderResponse.setOrderedArtWorkList(orderedArtWorks);

                orderResponseList.add(orderResponse);
            }
        }

        return orderResponseList;
    }

}

