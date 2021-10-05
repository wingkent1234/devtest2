package com.example.devtest2.repository;

import com.example.devtest2.entity.CredentialEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, String> {

    Optional<CredentialEntity> findByUsernameAndPassword(String username, String password);
}
