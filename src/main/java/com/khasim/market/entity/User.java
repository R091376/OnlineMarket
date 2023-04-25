package com.khasim.market.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "user-m")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message ="email must not be null")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "username must not be blank")
    @Column(name = "username", unique=true)
    private String username;
    
    @NotBlank(message = "password must not be blank")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "firstname must not be blank")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Pattern(regexp="(^$|[0-9]{10})", message="Enter valid mobile number or empty")
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Embedded
    private Address address;

}
