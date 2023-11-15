package com.restapi.service;

import com.restapi.dto.AddressDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Address;
import com.restapi.model.AppUser;
import com.restapi.repository.AddressRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.AddressRequest;
import com.restapi.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressDto addressDto;

    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);
        AppUser appUser = userRepository.findById(addressRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", addressRequest.getUserId()));
        address.setAppUser(appUser);
        addressRepository.save(address);
        return findAll();

    }

    private AddressResponse findAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressDto.mapToAddressResponse(addressList);
    }

    public AddressResponse updateAddress(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);
        AppUser appUser = userRepository.findById(addressRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", addressRequest.getUserId()));
        address.setAppUser(appUser);
        addressRepository.save(address);
        return findAll();
    }

    public AddressResponse deleteById(Integer id) {
        addressRepository.deleteById(Long.valueOf(id));
        return findAll();

    }
}
