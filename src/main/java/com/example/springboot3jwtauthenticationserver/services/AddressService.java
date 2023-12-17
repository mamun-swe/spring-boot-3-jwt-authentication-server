package com.example.springboot3jwtauthenticationserver.services;

import com.example.springboot3jwtauthenticationserver.dto.AddressCreateRequest;
import com.example.springboot3jwtauthenticationserver.dto.AddressUpdateRequest;
import com.example.springboot3jwtauthenticationserver.models.Address;
import com.example.springboot3jwtauthenticationserver.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * display the list of resources
     */
    public List<Address> getAddress(Long user_id) {
        List<Address> address = new ArrayList<Address>();
        this.addressRepository.findAll(user_id).stream().forEach(item -> address.add(item));

        return address;
    }

    /**
     * find specific resource by user_id
     **/
    public Optional<Address> getAddressById(Long id, Long user_id) {
        return this.addressRepository.findById(id, user_id);
    }

    /**
     * create new resource
     **/
    public void createAddress(Long user_id, AddressCreateRequest documents) {
        Address address = new Address();
        address.setUserId(user_id);
        address.setCountry(documents.getCountry());
        address.setCity(documents.getCity());
        address.setAddress(documents.getAddress());

        this.addressRepository.save(address);
    }

    /**
     * update a specific resource
     **/
    public void updateAddress(Long id, Long user_id, AddressUpdateRequest documents) {
        Address address = this.addressRepository.findById(id, user_id).get();
        address.setUserId(user_id);
        address.setCountry(documents.getCountry());
        address.setCity(documents.getCity());
        address.setAddress(documents.getAddress());

        this.addressRepository.save(address);
    }

    /**
     * delete a specific resource
     */
    public void destroyAddress(Long id) {
        this.addressRepository.deleteById(id);
    }
}
