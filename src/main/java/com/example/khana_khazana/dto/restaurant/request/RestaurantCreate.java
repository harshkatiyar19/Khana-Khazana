package com.example.khana_khazana.dto.restaurant.request;

import java.time.LocalTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "RestaurantCreate", description = "Payload to create a restaurant")
public record RestaurantCreate(
		@Schema(description = "Restaurant name", example = "Spice Villa") String name,
		@Schema(description = "Restaurant address", example = "123 Main Street, City") String address,
		@Schema(description = "Cuisine type", example = "Indian") String cuisine,
		@Schema(description = "Opening time", example = "10:00:00") LocalTime openTime,
		@Schema(description = "Closing time", example = "23:00:00") LocalTime closeTime,
        @Schema(description = "Image url", example = "23:00:00")String imgUrl
) { }