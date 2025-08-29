package com.example.khana_khazana.controller;

import com.example.khana_khazana.dto.booking.request.BookingCreate;
import com.example.khana_khazana.entity.BookingStatus;
import com.example.khana_khazana.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/booking")
@Tag(name = "Booking", description = "Booking creation, update, and query APIs")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	//creation
	@Operation(summary = "Create new booking", description = "Creates a booking with restaurant id, user id, time range, status, and number of people. All validations are handled in service.")
	@PostMapping("v1/new")
	public ResponseEntity<String> createNewBooking(@Parameter(description = "Booking creation request payload", required = true,
		schema = @Schema(implementation = BookingCreate.class))@RequestBody BookingCreate request) {
		try{
			return bookingService.createNewBooking(request);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}



	//getting
	@Operation(summary = "List bookings for user", description = "Returns all bookings associated with a user id.")
	@GetMapping("v1/user/{id}")
	public ResponseEntity<?> getAllBookingsByUser(@Parameter(description = "User id") @PathVariable Long id){
		try {
			return ResponseEntity.ok().body(bookingService.getAllBookingsByUser(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "List bookings for restaurant", description = "Returns all bookings associated with a restaurant id.")
	@GetMapping("v1/restaurant/{id}")
	public ResponseEntity<?> getAllBookingsByRestaurant(@Parameter(description = "Restaurant id") @PathVariable Long id){
		try {
			return ResponseEntity.ok().body(bookingService.getAllBookingsByUser(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
//---------------------------------------------------------------------------//
	@Operation(summary = "List bookings by open time", description = "Returns all bookings that open at the given time for a restaurant id.")
	@GetMapping("v1/restaurant/{id}/open-time/{openTime}")
	public ResponseEntity<?> getAllBookingsByOpenTime(@Parameter(description = "Opening time filter") @PathVariable LocalDateTime openTime){
		try {
			return ResponseEntity.ok().body(bookingService.getAllBookingsByOpenTime(openTime));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "List bookings by close time", description = "Returns all bookings that close at the given time for a restaurant id.")
	@GetMapping("v1/restaurant/{id}/close-time/{closeTime}")
	public ResponseEntity<?> getAllBookingsByCloseTime(@Parameter(description = "Closing time filter") @PathVariable LocalDateTime closeTime){
		try {
			return ResponseEntity.ok().body(bookingService.getAllBookingsByCloseTime(closeTime));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "List bookings by status", description = "Returns all bookings by status for a restaurant id.")
	@GetMapping("v1/restaurant/{id}/{status}")
	public ResponseEntity<?> getAllBookingsByStatus(@Parameter(description = "Status filter") @PathVariable BookingStatus status){
		try {
			return ResponseEntity.ok().body(bookingService.getAllBookingsByStatus(status));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "List bookings by people", description = "Returns all bookings matching number of people for a restaurant id.")
	@GetMapping("v1/restaurant/{id}/{people}")
	public ResponseEntity<?> getAllBookingsByNoOfPeople(@Parameter(description = "Number of people filter") @PathVariable Integer people){
		try {
			return ResponseEntity.ok().body(bookingService.getAllBookingsByNoOfPeople(people));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	//updation
	@Operation(summary = "Update booking open time", description = "Updates the opening time for a booking by id. Returns update result.")
	@PatchMapping("v1/{id}/update/open-time")
	public ResponseEntity<String> updateOpenTime(@Parameter(description = "Booking id") @PathVariable Long id, @Parameter(description = "New opening time") @RequestParam LocalTime newOpenTime){
		try {
			return bookingService.updateOpenTime(id,newOpenTime);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@Operation(summary = "Update booking close time", description = "Updates the closing time for a booking by id. Returns update result.")
	@PatchMapping("v1/{id}/update/close-time")
	public ResponseEntity<String> updateCloseTime(@Parameter(description = "Booking id") @PathVariable Long id, @Parameter(description = "New closing time") @RequestParam LocalTime newCloseTime){
		try {
			return bookingService.updateCloseTime(id,newCloseTime);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@Operation(summary = "Update booking status", description = "Updates the booking status by id. Returns update result.")
	@PatchMapping("v1/{id}/update/status")
	public ResponseEntity<String> updateStatus(@Parameter(description = "Booking id") @PathVariable Long id, @Parameter(description = "New status") @RequestParam BookingStatus newStatus){
		try {
			return bookingService.updateStatus(id,newStatus);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@Operation(summary = "Update booking people", description = "Updates number of people for a booking by id. Returns update result.")
	@PatchMapping("v1/{id}/update/people")
	public ResponseEntity<String> updatePeople(@Parameter(description = "Booking id") @PathVariable Long id, @Parameter(description = "New number of people") @RequestParam Integer newPeople){
		try {
			return bookingService.updatePeople(id,newPeople);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}
}
