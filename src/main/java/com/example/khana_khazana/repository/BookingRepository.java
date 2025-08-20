package com.example.khana_khazana.repository;

import com.example.khana_khazana.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
