package com.example.khana_khazana.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    @Id
    @SequenceGenerator(name="user_seq",sequenceName = "user_seq",allocationSize = 1,initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long userId;

    @Column(name="name",nullable = false, length = 100)
    private String name;

    @Column(name="email",nullable = false, unique = true, length = 150)
    private String email;

    @Column(name="password",nullable = false, length = 255)
    private String password;

    @Column(name="phone_number",nullable = false)
    private Long phoneNumber;

}
