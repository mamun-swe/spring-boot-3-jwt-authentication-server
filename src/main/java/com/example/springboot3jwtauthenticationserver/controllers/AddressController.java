package com.example.springboot3jwtauthenticationserver.controllers;

import com.example.springboot3jwtauthenticationserver.dto.AddressCreateRequest;
import com.example.springboot3jwtauthenticationserver.dto.AddressUpdateRequest;
import com.example.springboot3jwtauthenticationserver.exceptions.Response;
import com.example.springboot3jwtauthenticationserver.models.Address;
import com.example.springboot3jwtauthenticationserver.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

//    @Autowired
//    private AddressService addressService;
//
//    /**
//     * Display the list of resources
//     **/
//    @GetMapping()
//    ResponseEntity<Object> index() {
//        try {
//            Long user_id = 1L;
//            List<Address> address = this.addressService.getAddress(user_id);
//            return Response.Success(HttpStatus.OK, "List of your address.", address);
//        } catch (Exception e) {
//            return Response.InternalServerError();
//        }
//    }
//
//    /**
//     * Create new resource
//     **/
//    @PostMapping()
//    ResponseEntity<Object> store(@Valid @RequestBody AddressCreateRequest reqBody) {
//        try {
//            Long user_id = 1L;
//            this.addressService.createAddress(user_id, reqBody);
//            return Response.Success(HttpStatus.CREATED, "Address created.");
//        } catch (Exception e) {
//            return Response.InternalServerError();
//        }
//    }
//
//    /**
//     * Display specific resource
//     **/
//    @GetMapping()
//    ResponseEntity<Object> show(@PathVariable(name = "id", required = true) Long id) {
//        try {
//            Long user_id = 2L;
//
//            this.addressService.getAddressById(id, user_id);
//            return Response.Success(HttpStatus.CREATED, "Address created.");
//        } catch (Exception e) {
//            return Response.InternalServerError();
//        }
//    }
//
//    /**
//     * Update specific resource
//     **/
//    @PutMapping()
//    ResponseEntity<Object> update(@Valid @RequestBody AddressUpdateRequest reqBody, @PathVariable(name = "id", required = true) Long id) {
//        try {
//            Long user_id = 2L;
//            Optional<Address> availableAddress = this.addressService.getAddressById(id, user_id);
//            if (!availableAddress.isPresent()) {
//                Map<String, String> errors = new HashMap<>();
//                errors.put("address", "Address is not available.");
//                return Response.Error(HttpStatus.NOT_FOUND, "Not found.", errors);
//            }
//
//            this.addressService.updateAddress(id, user_id, reqBody);
//            return Response.Success(HttpStatus.CREATED, "Address updated.");
//        } catch (Exception e) {
//            return Response.InternalServerError();
//        }
//    }
//
//    /**
//     * Destroy specific resource
//     **/
//    @DeleteMapping()
//    ResponseEntity<Object> destroy(@PathVariable(name = "id", required = true) Long id) {
//        try {
//            Long user_id = 2L;
//            Optional<Address> availableAddress = this.addressService.getAddressById(id, user_id);
//            if (!availableAddress.isPresent()) {
//                Map<String, String> errors = new HashMap<>();
//                errors.put("address", "Address is not available.");
//                return Response.Error(HttpStatus.NOT_FOUND, "Not found.", errors);
//            }
//
//            this.addressService.destroyAddress(id);
//            return Response.Success(HttpStatus.OK, "Address destroyed.");
//        } catch (Exception e) {
//            return Response.InternalServerError();
//        }
//    }
}
