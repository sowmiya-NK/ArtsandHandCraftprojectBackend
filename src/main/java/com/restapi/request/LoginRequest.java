package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

//    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 3, message = "Username should have at least 3 characters")
//    @Email(message = "Invalid email format")
    private String username;

//    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 3, message = "Password should have at least 3 characters")
    private String password;
}
