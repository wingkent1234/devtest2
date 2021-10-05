package com.example.devtest2.controller;

import com.example.devtest2.entity.CustomerEntity;
import com.example.devtest2.service.DeleteService;
import com.example.devtest2.service.InsertService;
import com.example.devtest2.service.RetrieveService;
import com.example.devtest2.service.UpdateService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    private final InsertService insertService;
    private final RetrieveService retrieveService;
    private final UpdateService updateService;
    private final DeleteService deleteService;

    public CustomerController(InsertService insertService,
            RetrieveService retrieveService,
            UpdateService updateService,
            DeleteService deleteService) {
        this.insertService = insertService;
        this.retrieveService = retrieveService;
        this.updateService = updateService;
        this.deleteService = deleteService;
    }

    @PostMapping
    public String insert(@RequestBody CustomerEntity customerEntity) {
        insertService.insert(customerEntity);
        return "success";
    }

    @GetMapping
    public CustomerEntity retrieve(@RequestHeader("accessToken") String accessToken) {
        return retrieveService.execute(accessToken);
    }

    @PutMapping
    public CustomerEntity update(@RequestHeader("accessToken") String accessToken,
            @RequestBody CustomerEntity customerEntity) {
        return updateService.execute(accessToken, customerEntity);
    }

    @DeleteMapping
    public String update(@RequestHeader("accessToken") String accessToken) {
        return deleteService.execute(accessToken);
    }
}
