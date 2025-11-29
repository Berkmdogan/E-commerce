package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.mapper.CustomerMapper;
import com.example.ecommerce.request.CustomerRequest;
import com.example.ecommerce.response.CustomerResponse;
import com.example.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper CustomerMapper;

    @PostMapping("create")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerDto customerDto = CustomerMapper.toDto(customerRequest);
        return ResponseEntity.ok(CustomerMapper.toResponse(customerService.save(customerDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerRequest customerRequest) {
        CustomerDto customerDto = CustomerMapper.toDto(customerRequest);
        CustomerDto updatedCustomer = customerService.update(customerDto, id);
        return ResponseEntity.ok(CustomerMapper.toResponse(updatedCustomer));
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long id) {
        CustomerDto customerDto = customerService.getCustomer(id);
        return ResponseEntity.ok(CustomerMapper.toResponse(customerDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerDto> customerDtoList = customerService.getAllCustomer();
        List<CustomerResponse> customerResponseList = customerDtoList.stream()
                .map(CustomerMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
