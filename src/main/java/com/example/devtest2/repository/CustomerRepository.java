package com.example.devtest2.repository;

import com.example.devtest2.entity.CustomerEntity;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    public Optional<CustomerEntity> findById(BigInteger id);
}
