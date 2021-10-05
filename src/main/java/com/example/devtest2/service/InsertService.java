package com.example.devtest2.service;

import com.example.devtest2.entity.CustomerEntity;
import com.example.devtest2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class InsertService {

    private final CustomerRepository customerRepository;

    public InsertService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void insert(CustomerEntity request) {

        customerRepository.findById(request.getId())
                .ifPresent(customerEntity -> {
                    throw new RuntimeException("Id exist, cannot add");
                });

        customerRepository.save(request);
    }
}
