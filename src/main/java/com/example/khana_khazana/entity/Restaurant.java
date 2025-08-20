package com.example.khana_khazana.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @SequenceGenerator(name="rest_seq",sequenceName = "rest_seq",allocationSize = 1,initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rest_id")
    private Long restId;

    @Column(name ="name" ,nullable=false, length = 100)
    private String name;

    @Column(name ="address" ,nullable=false, length = 255)
    private String address;

    @Column(name ="cuisine" , length = 50)
    private String cuisine;

    @Column(name = "open_time", nullable = false)
    private LocalTime openTime;

    @Column(name = "close_time", nullable = false)
    private LocalTime closeTime;

    @Column(name = "no_of_tables", columnDefinition = "INTEGER DEFAULT 0")
    private Integer numberOfTables;

}
