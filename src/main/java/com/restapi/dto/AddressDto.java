package com.restapi.dto;

import com.restapi.model.Address;
import com.restapi.request.AddressRequest;
import com.restapi.response.AddressResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDto {
    public Address mapToAddress(AddressRequest addressRequest) {
        Address address = new Address();
        if (addressRequest.getId() != null)
            address.setId(addressRequest.getId());
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getStreet());
        address.setZipcode(addressRequest.getZipcode());
        return address;

    }

    public AddressResponse mapToAddressResponse(List<Address> addressList) {
        return new AddressResponse(addressList);
    }
}
