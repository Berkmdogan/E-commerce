package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.request.CustomerRequest;
import com.example.ecommerce.response.CustomerResponse;

public class CustomerMapper {
    public static CustomerDto toDto(CustomerRequest customerRequest) {
        return CustomerDto.builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .address(customerRequest.getAddress())
                .password(customerRequest.getPassword())
                .build();
    }

    public static CustomerResponse toResponse(CustomerDto customerDto) {
        return CustomerResponse.builder()
                .id(customerDto.getCustomerId())
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .email(customerDto.getEmail())
                .phoneNumber(customerDto.getPhoneNumber())
                .address(customerDto.getAddress())
                .build();
    }
    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .password(customer.getPassword())
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .customerId(customerDto.getCustomerId())
                .name(customerDto.getName())
                .surname(customerDto.getSurname())
                .email(customerDto.getEmail())
                .phoneNumber(customerDto.getPhoneNumber())
                .address(customerDto.getAddress())
                .password(customerDto.getPassword())
                .build();
    }
}
