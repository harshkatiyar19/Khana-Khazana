package com.example.khana_khazana.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Users", description = "User entity representing application users")
public class Users {

	@Id
	@SequenceGenerator(name="user_seq",sequenceName = "user_seq",allocationSize = 1,initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@Column(name = "user_id")
	@Schema(description = "Primary key of user", example = "10")
	private Long userId;

	@Column(name="name",nullable = false, length = 100)
	@Schema(description = "Full name of the user", example = "Aarav Sharma")
	private String name;

	@Column(name="email",nullable = false, unique = true, length = 150)
	@Schema(description = "Unique email address", example = "aarav@example.com")
	private String email;

	@Column(name="password",nullable = false, length = 255)
	@Schema(description = "Hashed password")
	private String password;

	@Column(name="phone_number",nullable = false)
	@Schema(description = "Phone number", example = "+91-9876543210")
	private String phoneNumber;

}
