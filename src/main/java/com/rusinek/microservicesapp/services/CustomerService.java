package com.rusinek.microservicesapp.services;

import com.rusinek.microservicesapp.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById(UUID customerId);
}
