package com.example.khana_khazana.controller;

import com.example.khana_khazana.dto.booking.request.BookingCreate;
import com.example.khana_khazana.entity.BookingStatus;
import com.example.khana_khazana.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    //creation
    @Operation(summary = "Create new booking", description = "all checks are at place.")
    @PostMapping("v1/new")
    public ResponseEntity<?> createNewBooking(@Parameter(description = "Booking creation request payload", required = true,
            schema = @Schema(implementation = BookingCreate.class))@RequestBody BookingCreate request) {
        try{
            return bookingService.createNewBooking(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }



    //getting
    @GetMapping("v1/user/{id}")
    public ResponseEntity<?> getAllBookingsByUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(bookingService.getAllBookingsByUser(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("v1/restaurant/{id}")
    public ResponseEntity<?> getAllBookingsByRestaurant(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(bookingService.getAllBookingsByUser(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
//---------------------------------------------------------------------------//
    @GetMapping("v1/restaurant/{id}/open-time/{openTime}")
    public ResponseEntity<?> getAllBookingsByOpenTime(@PathVariable LocalDateTime openTime){
        try {
            return ResponseEntity.ok().body(bookingService.getAllBookingsByOpenTime(openTime));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("v1/restaurant/{id}/close-time/{closeTime}")
    public ResponseEntity<?> getAllBookingsByCloseTime(@PathVariable LocalDateTime closeTime){
        try {
            return ResponseEntity.ok().body(bookingService.getAllBookingsByCloseTime(closeTime));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("v1/restaurant/{id}/{status}")
    public ResponseEntity<?> getAllBookingsByStatus(@PathVariable BookingStatus status){
        try {
            return ResponseEntity.ok().body(bookingService.getAllBookingsByStatus(status));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("v1/restaurant/{id}/{people}")
    public ResponseEntity<?> getAllBookingsByNoOfPeople(@PathVariable Integer people){
        try {
            return ResponseEntity.ok().body(bookingService.getAllBookingsByNoOfPeople(people));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    //updation
    @PatchMapping("v1/{id}/update/open-time")
    public ResponseEntity<?> updateOpenTime(@PathVariable Long id, @RequestParam LocalTime newOpenTime){
        try {
            return bookingService.updateOpenTime(id,newOpenTime);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/close-time")
    public ResponseEntity<?> updateCloseTime(@PathVariable Long id, @RequestParam LocalTime newCloseTime){
        try {
            return bookingService.updateCloseTime(id,newCloseTime);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestParam BookingStatus newStatus){
        try {
            return bookingService.updateStatus(id,newStatus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/people")
    public ResponseEntity<?> updatePeople(@PathVariable Long id, @RequestParam Integer newPeople){
        try {
            return bookingService.updatePeople(id,newPeople);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
