package com.rusinek.microservicesapp.services;

import com.rusinek.microservicesapp.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Adrian Rusinek on 30.07.2019
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("John")
                .build();
    }
}
