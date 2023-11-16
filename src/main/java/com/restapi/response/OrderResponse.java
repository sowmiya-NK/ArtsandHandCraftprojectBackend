package com.restapi.response;

import com.restapi.model.Address;
import com.restapi.model.OrderedArtWork;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private List<OrderedArtWork> orderedArtWorkList;
    private Long userId;
    private String username;
    private Address address;
    private String orderStatus;

}
