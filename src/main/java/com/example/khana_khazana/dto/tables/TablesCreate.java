package com.example.khana_khazana.dto.tables;

import com.example.khana_khazana.entity.Restaurant;

public record TablesCreate(
        Restaurant restaurant,Integer seats
) { }