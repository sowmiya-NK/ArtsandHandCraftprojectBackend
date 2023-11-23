package com.restapi.response;

import com.restapi.model.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private Long id;
    private String username;
    private String name;
    private String role;
    private Address address;
}
