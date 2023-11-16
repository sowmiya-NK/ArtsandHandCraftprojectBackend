package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatusRequest {
    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @NotNull(message = "Status ID cannot be null")
    private Long statusId;
}
