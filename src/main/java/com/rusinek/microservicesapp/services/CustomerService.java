package com.rusinek.microservicesapp.services;

import com.rusinek.microservicesapp.web.model.BeerDto;
import com.rusinek.microservicesapp.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById(UUID customerId);

    CustomerDTO saveNewCustomer(BeerDto beerDto);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteById(UUID customerId);
}
