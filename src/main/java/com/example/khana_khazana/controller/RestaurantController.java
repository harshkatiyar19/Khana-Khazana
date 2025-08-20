package com.example.khana_khazana.controller;

import com.example.khana_khazana.dto.restaurant.RestaurantCreate;
import com.example.khana_khazana.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    //creation
    @PostMapping("v1/new")
    public ResponseEntity<?> createNewRestaurant(@RequestBody RestaurantCreate request) {
        try{
            return restaurantService.createNewRestaurant(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    //updation
    @PatchMapping("v1/{id}/update/address")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestParam String newAddress){
        try {
            return restaurantService.updateAddress(id,newAddress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/open-time")
    public ResponseEntity<?> updateOpenTime(@PathVariable Long id, @RequestParam LocalTime newOpenTime){
        try {
            return restaurantService.updateOpenTime(id,newOpenTime);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/close-time")
    public ResponseEntity<?> updateCloseTime(@PathVariable Long id, @RequestParam LocalTime newCloseTime){
        try {
            return restaurantService.updateCloseTime(id,newCloseTime);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("v1/{id}/delete")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(restaurantService.deleteRestaurant(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
    // getting
    @GetMapping
    public ResponseEntity<?> getAllRestaurants(){
        try {
            return ResponseEntity.ok().body(restaurantService.getAllRestaurants());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(restaurantService.getRestaurantByName(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/name")
    public ResponseEntity<?> getAllRestaurantsByName(@RequestParam String name){
        try {
            return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/cuisine")
    public ResponseEntity<?> getAllRestaurantsByCuisine(@RequestParam String cuisine){
        try {
            return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByCuisine(cuisine));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/open-time")
    public ResponseEntity<?> getAllRestaurantsByOpenTime(@RequestParam LocalTime openTime){
        try {
            return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByOpenTime(openTime));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/v1/cuisines")
    public ResponseEntity<?> getAllCuisines(){
        try {
            return ResponseEntity.ok().body(restaurantService.getAllCuisines());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/v1/open-time")
    public ResponseEntity<?> getOpeningTimings(){
        try {
            return ResponseEntity.ok().body(restaurantService.getOpeningTimings());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/v1/close-time")
    public ResponseEntity<?> getClosingTimings(){
        try {
            return ResponseEntity.ok().body(restaurantService.getClosingTimings());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }


    //-------------------------------------------------------------------------//
    @PatchMapping("v1/{id}/update/cuisine")
    public ResponseEntity<?> updateCuisine(@PathVariable Long id, @RequestParam String newCuisine){
        try {
            return restaurantService.updateCuisine(id,newCuisine);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/tables")
    public ResponseEntity<?> updateNumberOfTables(@PathVariable Long id, @RequestParam Integer newNumberOfTables){
        try {
            return restaurantService.updateNumberOfTables(id,newNumberOfTables);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/close-time")
    public ResponseEntity<?> getAllRestaurantsByCloseTime(@RequestParam LocalTime closeTime){
        try {
            return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByCloseTime(closeTime));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/no-of-tables")
    public ResponseEntity<?> getAllRestaurantsByNumberOfTables(@RequestParam Integer numberOfTables){
        try {
            return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByNumberOfTables(numberOfTables));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/v1/no-of-tables")
    public ResponseEntity<?> getNumberOfTables(){
        try {
            return ResponseEntity.ok().body(restaurantService.getNumberOfTables());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
