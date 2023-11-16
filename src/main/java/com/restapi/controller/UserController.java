package com.restapi.controller;

import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.request.AddressRequest;
import com.restapi.response.AddressResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.AddressService;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RolesAllowed(Role.USER)
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/{userId}")
    private ResponseEntity<APIResponse> getAllUserDetails(@PathVariable Long userId){
      AppUser appUser= userService.findUserById(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(appUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @PostMapping
    private ResponseEntity<APIResponse> createAddress(@RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse=addressService.createAddress(addressRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(addressResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<APIResponse> updateAddress( @RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse=addressService.updateAddress(addressRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(addressResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<APIResponse> deleteAddress(@PathVariable Integer id){
       AddressResponse addressResponse=addressService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(addressResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
