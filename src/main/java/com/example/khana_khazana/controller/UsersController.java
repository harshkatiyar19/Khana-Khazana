package com.example.khana_khazana.controller;

import com.example.khana_khazana.dto.users.request.UsersCreate;
import com.example.khana_khazana.dto.users.request.UsersEmail;
import com.example.khana_khazana.dto.users.request.UsersPhone;
import com.example.khana_khazana.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@ControllerAdvice
@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "User sign-up, sign-in and profile management APIs")
public class UsersController {

	@Autowired
	private UsersService usersService;

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Sign up new user", description = "Creates a new user account using name, email, password, and phone number. Returns created user details or error.")
	@PostMapping("v1/signup")
	public ResponseEntity<?> createNewUser(@RequestBody UsersCreate request) {

			return ResponseEntity.ok(usersService.createNewUser(request));

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Sign in with phone", description = "Authenticates a user with phone and password. Returns authentication result/response.")
	@PostMapping("v1/signin/phone-number")
	public ResponseEntity<?> signInPhone(@RequestBody UsersPhone request){

			return usersService.signInPhone(request);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Sign in with email", description = "Authenticates a user with email and password. Returns authentication result/response.")
	@PostMapping("v1/signin/email")
	public ResponseEntity<?> signInEmail(@RequestBody UsersEmail request){

			return usersService.signInEmail(request);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Update user email", description = "Updates the email of a user identified by id. Returns update result.")
	@PatchMapping("v1/{id}/update/email")
	public ResponseEntity<?> updateEmail(@Parameter(description = "User id") @PathVariable Long id,@RequestBody UsersEmail request){

			return usersService.updateEmail(id,request);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Update user phone", description = "Updates the phone number of a user identified by id. Returns update result.")
	@PatchMapping("v1/{id}/update/phone-number")
	public ResponseEntity<?> updatePhone(@Parameter(description = "User id") @PathVariable Long id,@RequestBody UsersPhone request){

			return usersService.updatePhone(id,request);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Delete user", description = "Deletes a user identified by id if password matches. Returns deletion result.")
	@DeleteMapping("v1/{id}/delete")
	public ResponseEntity<?> deleteUser(@Parameter(description = "User id") @PathVariable Long id,@Parameter(description = "Current account password") @RequestParam String password){

			return ResponseEntity.ok().body(usersService.deleteUser(id,password));
	}

}
