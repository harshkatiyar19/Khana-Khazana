package com.example.khana_khazana.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tables")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tableId;

    @ManyToOne
    @JoinColumn(name = "rest_id", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private Integer seats;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;
}
