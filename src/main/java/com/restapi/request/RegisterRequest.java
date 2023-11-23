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
public class
RegisterRequest {

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password should have at least 8 characters")

    private String password;

    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

}
