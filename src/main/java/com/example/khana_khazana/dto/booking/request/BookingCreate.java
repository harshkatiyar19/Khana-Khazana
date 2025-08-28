package com.example.khana_khazana.dto.booking.request;

import com.example.khana_khazana.entity.BookingStatus;

import java.time.LocalDateTime;

public record BookingCreate(
        Long restId,
        Long userId,
//        Tables table,
        LocalDateTime openTime,
        LocalDateTime closeTime,
        BookingStatus status ,
        Integer people
) {
}
