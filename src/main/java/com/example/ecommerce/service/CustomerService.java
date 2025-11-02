package com.example.ecommerce.service;

import com.example.ecommerce.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto , Long id);

    CustomerDto getCustomer(Long id);

    List<CustomerDto> getAllCustomer();

    void delete(Long id);
}
