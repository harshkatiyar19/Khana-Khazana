package com.example.khana_khazana.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "BookingStatus", description = "Possible booking statuses")
public enum BookingStatus {
    pending, confirm, cancelled
}
