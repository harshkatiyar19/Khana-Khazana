package com.example.khana_khazana.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(
			title = "Khana Khazana API",
			version = "v1",
			description = "APIs for managing users, restaurants, tables, and bookings.",
			contact = @Contact(name = "Khana Khazana Team")
	),
	servers = {
		@Server(url = "/", description = "Default Server")
	}
)
public class OpenApiConfig { } 