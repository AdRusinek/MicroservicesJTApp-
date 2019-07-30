package com.rusinek.microservicesapp.services;

import com.rusinek.microservicesapp.web.model.BeerDto;
import com.rusinek.microservicesapp.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Adrian Rusinek on 30.07.2019
 **/
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("John")
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomer(BeerDto beerDto) {

        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        // todo impl
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting customer with id: " + customerId);
    }
}
