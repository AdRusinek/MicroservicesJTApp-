package com.rusinek.microservicesapp.web.controller;

import com.rusinek.microservicesapp.services.CustomerService;
import com.rusinek.microservicesapp.web.model.BeerDto;
import com.rusinek.microservicesapp.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Adrian Rusinek on 30.07.2019
 **/
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Valid @RequestBody BeerDto beerDto) {
        CustomerDTO savedDto = customerService.saveNewCustomer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location",
                "http://localhost:8080/api/v1/customer/" + savedDto.getId().toString());

        return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable UUID customerId, @Valid @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerId, customerDTO);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID customerId) {
        customerService.deleteById(customerId);
    }

}
