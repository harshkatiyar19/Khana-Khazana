package com.example.khana_khazana.dto.restaurant.request;

import java.time.LocalTime;

public record RestaurantResponse(
        Long restId,
        String name,
        String address,
        String cuisine,
        LocalTime openTime,
        LocalTime closeTime,
        String imgUrl
) {
}
