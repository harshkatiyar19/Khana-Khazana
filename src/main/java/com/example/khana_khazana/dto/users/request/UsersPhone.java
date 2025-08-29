package com.example.khana_khazana.dto.users.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UsersPhone", description = "Payload to authenticate or update phone number")
public record UsersPhone(
     @Schema(description = "Phone number with country code", example = "+91-9876543210") String phone,
     @Schema(description = "Password for verification", example = "P@ssw0rd!") String password
) { }