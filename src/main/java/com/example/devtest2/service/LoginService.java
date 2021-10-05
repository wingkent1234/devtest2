package com.example.devtest2.service;

import com.example.devtest2.entity.AuthEntity;
import com.example.devtest2.model.LoginRequestModel;
import com.example.devtest2.model.LoginResponseModel;
import com.example.devtest2.repository.AuthRepository;
import com.example.devtest2.repository.CredentialRepository;
import java.math.BigInteger;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final AuthRepository authRepository;
    private final CredentialRepository credentialRepository;

    public LoginService(AuthRepository authRepository,
            CredentialRepository credentialRepository) {
        this.authRepository = authRepository;
        this.credentialRepository = credentialRepository;
    }

    public LoginResponseModel execute(LoginRequestModel loginRequestModel) {
        var credential = credentialRepository.findByUsernameAndPassword(loginRequestModel.getUserName(), loginRequestModel.getPassword())
                .orElseThrow(() -> new RuntimeException("no credential found"));

        //TODO expires accessToken if user logout or over X minutes of time
        String accessToken = UUID.randomUUID().toString();
        AuthEntity authEntity = AuthEntity.builder()
                .customerId(new BigInteger(credential.getCustomerId()))
                .accessToken(accessToken)
                .build();
        authRepository.save(authEntity);
        return LoginResponseModel.builder().accessToken(accessToken).build();
    }
}
