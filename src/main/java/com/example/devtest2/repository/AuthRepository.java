package com.example.devtest2.repository;

import com.example.devtest2.entity.AuthEntity;
import com.example.devtest2.entity.CredentialEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, String> {
    Optional<AuthEntity> findByAccessToken(String accessToken);
}
