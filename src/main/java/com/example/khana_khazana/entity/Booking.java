package com.example.khana_khazana.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Booking", description = "Booking entity representing a reservation record")
public class Booking {

    @Id
    @SequenceGenerator(name="booking_seq",sequenceName = "booking_seq",allocationSize = 1,initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "booking_seq")
    @Column(name = "booking_id")
    @Schema(description = "Primary key of booking", example = "10")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "rest_id", nullable = false , referencedColumnName = "rest_id")
    @Schema(description = "Restaurant of the booking")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    @Schema(description = "User who created the booking")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false, referencedColumnName = "table_id")
    @Schema(description = "Allocated table for the booking")
    private Tables table;

    @Column(name = "open_time", nullable = false)
    @Schema(description = "Opening time of booking window", example = "2025-08-30T19:00:00")
    private LocalDateTime openTime;

    @Column(name = "close_time", nullable = false)
    @Schema(description = "Closing time of booking window", example = "2025-08-30T21:00:00")
    private LocalDateTime closeTime;

    @Column(name="status" ,nullable = false)
    @Schema(description = "Current booking status", example = "pending")
    private BookingStatus status = BookingStatus.pending;

    @Column(name="people",nullable = false)
    @Schema(description = "Number of people for the booking", example = "4")
    private Integer people;
}
