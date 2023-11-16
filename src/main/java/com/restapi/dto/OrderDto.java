package com.restapi.dto;

import com.restapi.model.Order;
import com.restapi.model.OrderedArtWork;
import com.restapi.repository.OrderArtWorkRepository;
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
        for (Order order : orderList) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(order.getId());
            orderResponse.setUserId(order.getAppUser().getId());
            orderResponse.setUsername(order.getAppUser().getUsername());
            orderResponse.setOrderStatus(order.getOrderStatus().getStatus());
            orderResponse.setAddress(order.getAddress());
            List<OrderedArtWork> orderedArtWorks = orderArtWorkRepository.findAll();
            orderResponse.setOrderedArtWorkList(orderedArtWorks);
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }

}
