package com.restapi.request;

import com.restapi.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class OrderRequest {
    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Address ID cannot be null")
    private Long addressId;

    @NotNull(message = "Artwork ID cannot be null")
    private Long artWorkId;
    private Long cartId;
}
