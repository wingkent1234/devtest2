package com.example.devtest2.service;

import com.example.devtest2.entity.CustomerEntity;
import com.example.devtest2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class RetrieveService {

    private final CustomerRepository customerRepository;
    private final ValidateAccessTokenService validateAccessTokenService;

    public RetrieveService(CustomerRepository customerRepository,
            ValidateAccessTokenService validateAccessTokenService) {
        this.customerRepository = customerRepository;
        this.validateAccessTokenService = validateAccessTokenService;
    }

    public CustomerEntity execute(String accessToken) {
        var customerId = validateAccessTokenService.validateAccessToken(accessToken);

        return customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("No customer found"));
    }

}
