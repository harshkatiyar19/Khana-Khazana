package com.example.khana_khazana.dto.booking;

import com.example.khana_khazana.entity.BookingStatus;
import com.example.khana_khazana.entity.Restaurant;
import com.example.khana_khazana.entity.Tables;
import com.example.khana_khazana.entity.Users;

import java.time.LocalDateTime;

public record BookingCreate(
        Restaurant restaurant,
        Users user,
        Tables table,
        LocalDateTime openTime,
        LocalDateTime closeTime,
        BookingStatus status ,
        Integer people
) {
}
