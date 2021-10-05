package com.example.devtest2.service;

import com.example.devtest2.entity.CustomerEntity;
import com.example.devtest2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {

    private final CustomerRepository customerRepository;
    private final ValidateAccessTokenService validateAccessTokenService;

    public UpdateService(CustomerRepository customerRepository,
            ValidateAccessTokenService validateAccessTokenService) {
        this.customerRepository = customerRepository;
        this.validateAccessTokenService = validateAccessTokenService;
    }

    public CustomerEntity execute(String accessToken, CustomerEntity request) {
        var customerId = validateAccessTokenService.validateAccessToken(accessToken);

        var customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("No customer found"));

        customer.setName(request.getName());
        customer.setPhone(request.getPhone());

        return customerRepository.save(customer);
    }

}
