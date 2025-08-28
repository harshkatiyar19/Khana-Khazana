package com.example.khana_khazana.dto.booking.request;

import com.example.khana_khazana.entity.BookingStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(name = "BookingCreate", description = "Payload to create a booking")
public record BookingCreate(
		@Schema(description = "Restaurant id for which booking is created", example = "10") Long restId,
		@Schema(description = "User id creating the booking", example = "15") Long userId,
		//        Tables table,
		@Schema(description = "Opening time of booking window", example = "2025-08-30T19:00:00") LocalDateTime openTime,
		@Schema(description = "Closing time of booking window", example = "2025-08-30T21:00:00") LocalDateTime closeTime,
		@Schema(description = "Initial status of the booking", example = "pending") BookingStatus status ,
		@Schema(description = "Number of people for the booking", example = "4") Integer people
) {
}
