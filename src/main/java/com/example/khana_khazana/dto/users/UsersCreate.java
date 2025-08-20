package com.example.khana_khazana.dto.users;

public record UsersCreate(
        String name,
        String email,
        String password,
        Long phoneNumber
) { }

//Long userId,
//String name,
//String email,
//String password,
//Long phoneNumber