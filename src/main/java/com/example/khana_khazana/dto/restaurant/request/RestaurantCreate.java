package com.example.khana_khazana.dto.restaurant.request;

import java.time.LocalTime;

public record RestaurantCreate(
        String name,
        String address,
        String cuisine,
        LocalTime openTime,
        LocalTime closeTime
) { }