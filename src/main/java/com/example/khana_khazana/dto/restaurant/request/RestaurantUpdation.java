package com.example.khana_khazana.dto.restaurant.request;

import java.time.LocalTime;

public record RestaurantUpdation(
        String address,
        String cuisine,
        LocalTime openTime,
        LocalTime closeTime
) {
}
