package com.example.khana_khazana.dto.booking.request;

import com.example.khana_khazana.entity.BookingStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record BookingUpdation(
       LocalTime openTime,
       LocalTime closeTime,
       BookingStatus status,
       Integer people
) {
}
