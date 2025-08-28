package com.example.khana_khazana.dto.users.request;

public record UsersCreate(
        String name,
        String email,
        String password,
        String confirmPassword,
        String phoneNumber
) { }

//Long userId,
//String name,
//String email,
//String password,
//Long phoneNumber