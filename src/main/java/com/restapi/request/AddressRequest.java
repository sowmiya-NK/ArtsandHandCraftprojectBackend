package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private Long id;
    private Long userId;

    @NotEmpty(message = "Street name cannot be empty")
    @Size(min = 3, message = "street name should have at least 3 characters")
    private String Street;

    @NotEmpty(message = "city name cannot be empty")
    @Size(min = 3, message = "city should have at least 3 characters")
    private String city;

    @NotEmpty(message = "zipcode  cannot be empty")
    @Size(min = 6, max = 6,message = "please enter correct zipcode")
    private Integer zipcode;
}
