package com.example.devtest2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credential")
public class CredentialEntity {
    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "username")
    private String username;

    //TODO password encryption
    @Column(name = "password")
    private String password;
}
