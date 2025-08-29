package com.example.khana_khazana.dto.users.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UsersCreate", description = "Payload to create a new user account")
public record UsersCreate(
		@Schema(description = "Full name of the user", example = "Aarav Sharma") String name,
		@Schema(description = "Email address", example = "aarav@example.com") String email,
		@Schema(description = "Password", example = "P@ssw0rd!") String password,
		@Schema(description = "Confirm password", example = "P@ssw0rd!") String confirmPassword,
		@Schema(description = "Phone number with country code", example = "+91-9876543210") String phoneNumber
) { }

//Long userId,
//String name,
//String email,
//String password,
//Long phoneNumber