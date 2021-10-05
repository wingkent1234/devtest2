package com.example.devtest2.service;

import com.example.devtest2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {

    private final CustomerRepository customerRepository;
    private final ValidateAccessTokenService validateAccessTokenService;

    public DeleteService(CustomerRepository customerRepository,
            ValidateAccessTokenService validateAccessTokenService) {
        this.customerRepository = customerRepository;
        this.validateAccessTokenService = validateAccessTokenService;
    }

    public String execute(String accessToken) {
        var customerId = validateAccessTokenService.validateAccessToken(accessToken);

        var customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("No customer found"));

        customerRepository.delete(customer);

        return "success";
    }

}
