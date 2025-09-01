package com.example.khana_khazana.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tables")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Tables", description = "Table entity representing a restaurant table")
public class Tables {

	@Id
	@SequenceGenerator(name="table_seq",sequenceName = "table_seq",allocationSize = 1,initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "table_seq")
	@Column(name = "table_id")
	@Schema(description = "Primary key of table", example = "10")
	private Long tableId;

	@ManyToOne
	@JoinColumn(name = "rest_id", nullable = false,referencedColumnName = "rest_id")
	@Schema(description = "Restaurant this table belongs to")
	private Restaurant restaurant;

	@Column(name = "seats",nullable = false)
	@Schema(description = "Number of seats at the table", example = "4")
	private Integer seats;
}