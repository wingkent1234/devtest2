package com.example.devtest2.controller;

import com.example.devtest2.model.LoginRequestModel;
import com.example.devtest2.model.LoginResponseModel;
import com.example.devtest2.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final LoginService loginService;

    public AuthController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login")
    public LoginResponseModel login(@RequestBody LoginRequestModel requestModel) {
        return loginService.execute(requestModel);
    }
}
