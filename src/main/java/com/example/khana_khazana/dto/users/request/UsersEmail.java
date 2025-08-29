package com.example.khana_khazana.dto.users.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UsersEmail", description = "Payload to authenticate or update email")
public record UsersEmail(
		@Schema(description = "Email address", example = "aarav@example.com") String email,
		@Schema(description = "Password for verification", example = "P@ssw0rd!") String password
) { }