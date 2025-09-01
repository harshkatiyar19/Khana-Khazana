package com.example.khana_khazana.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Restaurant", description = "Restaurant entity representing a restaurant record")
public class Restaurant {

	@Id
	@SequenceGenerator(name="rest_seq",sequenceName = "rest_seq",allocationSize = 1,initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rest_seq")
	@Column(name = "rest_id")
	@Schema(description = "Primary key of restaurant", example = "10")
	private Long restId;

	@Column(name ="name" ,nullable=false, length = 100)
	@Schema(description = "Restaurant name", example = "Spice Villa")
	private String name;

	@Column(name ="address" ,nullable=false)
	@Schema(description = "Full address of the restaurant", example = "123 Main Street, City")
	private String address;

	@Column(name ="cuisine" , length = 50)
	@Schema(description = "Cuisine type", example = "Indian")
	private String cuisine;

	@Column(name = "open_time", nullable = false)
	@Schema(description = "Opening time", example = "10:00:00")
	private LocalTime openTime;

	@Column(name = "close_time", nullable = false)
	@Schema(description = "Closing time", example = "23:00:00")
	private LocalTime closeTime;

	@Column(name = "no_of_tables", columnDefinition = "INTEGER DEFAULT 0")
	@Schema(description = "Number of tables available", example = "12")
	private Integer numberOfTables;

    @Column(name="img_url")
    @Schema(description = "Images of restaurant")
    private String imgUrl;
}
