package com.example.khana_khazana.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @SequenceGenerator(name="booking_seq",sequenceName = "booking_seq",allocationSize = 1,initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "rest_id", nullable = false , referencedColumnName = "rest_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false, referencedColumnName = "table_id")
    private Tables table;

    @Column(name = "open_time", nullable = false)
    private LocalDateTime openTime;

    @Column(name = "close_time", nullable = false)
    private LocalDateTime closeTime;

    @Column(name="status" ,nullable = false)
    private BookingStatus status = BookingStatus.pending;

    @Column(name="people",nullable = false)
    private Integer people;
}
