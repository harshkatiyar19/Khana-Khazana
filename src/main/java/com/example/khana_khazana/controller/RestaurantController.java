package com.example.khana_khazana.controller;

import com.example.khana_khazana.dto.restaurant.request.RestaurantCreate;
import com.example.khana_khazana.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/restaurant")
@Tag(name = "Restaurant", description = "Restaurant creation, update, delete, and query APIs")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	//creation
	@Operation(summary = "Create new restaurant", description = "Creates a restaurant with name, address, cuisine and opening/closing times. Returns created restaurant details.")
	@PostMapping("v1/new")
	public ResponseEntity<?> createNewRestaurant(@RequestBody RestaurantCreate request) {
		try{
			return ResponseEntity.ok(restaurantService.createNewRestaurant(request));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	//updation
	@Operation(summary = "Update restaurant address", description = "Updates restaurant address by id. Returns update result.")
	@PatchMapping("v1/{id}/update/address")
	public ResponseEntity<?> updateAddress(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New address") @RequestParam String newAddress){
		try {
			return restaurantService.updateAddress(id,newAddress);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Update restaurant open time", description = "Updates opening time by id. Returns update result.")
	@PatchMapping("v1/{id}/update/open-time")
	public ResponseEntity<?> updateOpenTime(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New opening time") @RequestParam LocalTime newOpenTime){
		try {
			return restaurantService.updateOpenTime(id,newOpenTime);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Update restaurant close time", description = "Updates closing time by id. Returns update result.")
	@PatchMapping("v1/{id}/update/close-time")
	public ResponseEntity<?> updateCloseTime(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New closing time") @RequestParam LocalTime newCloseTime){
		try {
			return restaurantService.updateCloseTime(id,newCloseTime);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Delete restaurant", description = "Deletes a restaurant by id. Returns deletion result.")
	@DeleteMapping("v1/{id}/delete")
	public ResponseEntity<?> deleteRestaurant(@Parameter(description = "Restaurant id") @PathVariable Long id){
		try {
			return ResponseEntity.ok().body(restaurantService.deleteRestaurant(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	// getting
	@Operation(summary = "List restaurants", description = "Returns all restaurants.")
	@GetMapping
	public ResponseEntity<?> getAllRestaurants(){
		try {
			return ResponseEntity.ok().body(restaurantService.getAllRestaurants());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Get restaurant by id", description = "Returns restaurant details by id.")
	@GetMapping("/v1/{id}")
	public ResponseEntity<?> getRestaurantById(@Parameter(description = "Restaurant id") @PathVariable Long id){
		try {
			return ResponseEntity.ok().body(restaurantService.getRestaurantById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Search restaurants by name", description = "Returns all restaurants matching a given name.")
	@GetMapping("/name")
	public ResponseEntity<?> getAllRestaurantsByName(@Parameter(description = "Name to match") @RequestParam String name){
		try {
			return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByName(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Search restaurants by cuisine", description = "Returns all restaurants for a cuisine.")
	@GetMapping("/cuisine")
	public ResponseEntity<?> getAllRestaurantsByCuisine(@Parameter(description = "Cuisine name") @RequestParam String cuisine){
		try {
			return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByCuisine(cuisine));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Search restaurants by opening time", description = "Returns all restaurants that open at the provided time.")
	@GetMapping("/open-time")
	public ResponseEntity<?> getAllRestaurantsByOpenTime(@Parameter(description = "Opening time filter") @RequestParam LocalTime openTime){
		try {
			return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByOpenTime(openTime));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "List all cuisines", description = "Returns all distinct cuisines.")
	@GetMapping("/v1/cuisines")
	public ResponseEntity<?> getAllCuisines(){
		try {
			return ResponseEntity.ok().body(restaurantService.getAllCuisines());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Get opening timings", description = "Returns configured restaurant opening time range or examples.")
	@GetMapping("/v1/open-time")
	public ResponseEntity<?> getOpeningTimings(){
		try {
			return ResponseEntity.ok().body(restaurantService.getOpeningTimings());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Get closing timings", description = "Returns configured restaurant closing time range or examples.")
	@GetMapping("/v1/close-time")
	public ResponseEntity<?> getClosingTimings(){
		try {
			return ResponseEntity.ok().body(restaurantService.getClosingTimings());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	//-------------------------------------------------------------------------//
	@Operation(summary = "Update restaurant cuisine", description = "Updates the cuisine of a restaurant by id. Returns update result.")
	@PatchMapping("v1/{id}/update/cuisine")
	public ResponseEntity<?> updateCuisine(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New cuisine") @RequestParam String newCuisine){
		try {
			return restaurantService.updateCuisine(id,newCuisine);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Search restaurants by closing time", description = "Returns all restaurants that close at the provided time.")
	@GetMapping("/close-time")
	public ResponseEntity<?> getAllRestaurantsByCloseTime(@Parameter(description = "Closing time filter") @RequestParam LocalTime closeTime){
		try {
			return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByCloseTime(closeTime));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Search restaurants by number of tables", description = "Returns all restaurants matching the given number of tables.")
	@GetMapping("/no-of-tables")
	public ResponseEntity<?> getAllRestaurantsByNumberOfTables(@Parameter(description = "Number of tables filter") @RequestParam Integer numberOfTables){
		try {
			return ResponseEntity.ok().body(restaurantService.getAllRestaurantsByNumberOfTables(numberOfTables));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Get number of tables", description = "Returns the total number of tables across restaurants or configuration value.")
	@GetMapping("/v1/no-of-tables")
	public ResponseEntity<?> getNumberOfTables(){
		try {
			return ResponseEntity.ok().body(restaurantService.getNumberOfTables());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
}
