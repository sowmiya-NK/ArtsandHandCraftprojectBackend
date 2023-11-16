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

    @NotEmpty
    private String Street;

    @NotEmpty
    @Size(min = 3, message = "city should have at least 3 characters")
    private String city;

    @NotEmpty
    @Size(min = 6, max = 6,message = "please enter correct zipcode")
    private Integer zipcode;
}
