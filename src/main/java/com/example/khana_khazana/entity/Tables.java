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
    @SequenceGenerator(name="table_seq",sequenceName = "table_seq",allocationSize = 1,initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "table_id")
    private Long tableId;

    @ManyToOne
    @JoinColumn(name = "rest_id", nullable = false,referencedColumnName = "rest_id")
    private Restaurant restaurant;

    @Column(name = "seats",nullable = false)
    private Integer seats;
}
