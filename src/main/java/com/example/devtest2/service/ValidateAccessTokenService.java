package com.example.devtest2.service;

import com.example.devtest2.repository.AuthRepository;
import java.math.BigInteger;
import org.springframework.stereotype.Service;

@Service
public class ValidateAccessTokenService {

    private final AuthRepository authRepository;

    public ValidateAccessTokenService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public BigInteger validateAccessToken(String accessToken) {
        var auth = authRepository.findByAccessToken(accessToken)
            .orElseThrow(() -> new RuntimeException("Not authenticated"));

        return auth.getCustomerId();
    }
}
