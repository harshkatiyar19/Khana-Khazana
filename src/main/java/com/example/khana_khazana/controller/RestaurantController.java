package com.example.khana_khazana.controller;

import com.example.khana_khazana.dto.restaurant.request.RestaurantCreate;
import com.example.khana_khazana.dto.restaurant.request.RestaurantUpdation;
import com.example.khana_khazana.entity.Restaurant;
import com.example.khana_khazana.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@ControllerAdvice
@CrossOrigin("*")
@RestController
@RequestMapping("/api/restaurant")
@Tag(name = "Restaurant", description = "Restaurant creation, update, delete, and query APIs")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;

	//creation
    @ExceptionHandler(Exception.class)
	@Operation(summary = "Create new restaurant", description = "Creates a restaurant with name, address, cuisine and opening/closing times. Returns created restaurant details.")
	@PostMapping("v1/new")
	public ResponseEntity<String> createNewRestaurant(@RequestBody RestaurantCreate request) {

			return restaurantService.createNewRestaurant(request);

	}

	//updation
//    @ExceptionHandler(Exception.class)
//	@Operation(summary = "Update restaurant address", description = "Updates restaurant address by id. Returns update result.")
//	@PatchMapping("v1/{id}/update/address")
//	public ResponseEntity<?> updateAddress(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New address") @RequestParam String newAddress){
//
//			return restaurantService.updateAddress(id,newAddress);
//
//	}

//    @ExceptionHandler(Exception.class)
//	@Operation(summary = "Update restaurant open time", description = "Updates opening time by id. Returns update result.")
//	@PatchMapping("v1/{id}/update/open-time")
//	public ResponseEntity<?> updateOpenTime(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New opening time") @RequestParam LocalTime newOpenTime){
//
//			return restaurantService.updateOpenTime(id,newOpenTime);
//
//	}
//
//    @ExceptionHandler(Exception.class)
//	@Operation(summary = "Update restaurant close time", description = "Updates closing time by id. Returns update result.")
//	@PatchMapping("v1/{id}/update/close-time")
//	public ResponseEntity<?> updateCloseTime(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New closing time") @RequestParam LocalTime newCloseTime){
//
//			return restaurantService.updateCloseTime(id,newCloseTime);
//
//	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Delete restaurant", description = "Deletes a restaurant by id. Returns deletion result.")
	@DeleteMapping("v1/{id}/delete")
	public ResponseEntity<String> deleteRestaurant(@Parameter(description = "Restaurant id") @PathVariable Long id){

			return restaurantService.deleteRestaurant(id);

	}
	// getting
    @ExceptionHandler(Exception.class)
	@Operation(summary = "List restaurants", description = "Returns all restaurants.")
	@GetMapping
	public ResponseEntity<List<Restaurant>> getAllRestaurants(){

			return restaurantService.getAllRestaurants();

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Get restaurant by id", description = "Returns restaurant details by id.")
	@GetMapping("/v1/{id}")
	public ResponseEntity<Optional<Restaurant>> getRestaurantById(@Parameter(description = "Restaurant id") @PathVariable Long id){

			return restaurantService.getRestaurantById(id);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Search restaurants by name", description = "Returns all restaurants matching a given name.")
	@GetMapping("/name")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByName(@Parameter(description = "Name to match") @RequestParam String name){

			return restaurantService.getAllRestaurantsByName(name);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Search restaurants by cuisine", description = "Returns all restaurants for a cuisine.")
	@GetMapping("/cuisine")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByCuisine(@Parameter(description = "Cuisine name") @RequestParam String cuisine){

			return restaurantService.getAllRestaurantsByCuisine(cuisine);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Search restaurants by opening time", description = "Returns all restaurants that open at the provided time.")
	@GetMapping("/open-time")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByOpenTime(@Parameter(description = "Opening time filter") @RequestParam LocalTime openTime){

			return restaurantService.getAllRestaurantsByOpenTime(openTime);

	}



	//-------------------------------------------------------------------------//
//    @ExceptionHandler(Exception.class)
//	@Operation(summary = "Update restaurant cuisine", description = "Updates the cuisine of a restaurant by id. Returns update result.")
//	@PatchMapping("v1/{id}/update/cuisine")
//	public ResponseEntity<?> updateCuisine(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New cuisine") @RequestParam String newCuisine){
//
//			return restaurantService.updateCuisine(id,newCuisine);
//
//	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Search restaurants by closing time", description = "Returns all restaurants that close at the provided time.")
	@GetMapping("/close-time")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByCloseTime(@Parameter(description = "Closing time filter") @RequestParam LocalTime closeTime){

			return restaurantService.getAllRestaurantsByCloseTime(closeTime);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Search restaurants by number of tables", description = "Returns all restaurants matching the given number of tables.")
	@GetMapping("/no-of-tables")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByNumberOfTables(@Parameter(description = "Number of tables filter") @RequestParam Integer numberOfTables){

			return restaurantService.getAllRestaurantsByNumberOfTables(numberOfTables);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Get number of tables", description = "Returns the total number of tables across restaurants or configuration value.")
	@GetMapping("/v1/no-of-tables")
	public ResponseEntity<?> getNumberOfTables(){

			return ResponseEntity.ok().body(restaurantService.getNumberOfTables());

	}

    @ExceptionHandler(Exception.class)
    @Operation(summary = "Update restaurant cuisine", description = "Updates the cuisine of a restaurant by id. Returns update result.")
    @PatchMapping("v1/{id}/update")
    public ResponseEntity<List<String>> updateRestaurant(@Parameter(description = "Restaurant id") @PathVariable Long id, @Parameter(description = "New cuisine") @RequestParam RestaurantUpdation request){

        return restaurantService.updateRestaurant(id, request);

    }

    @ExceptionHandler(Exception.class)
    @Operation(summary = "List all cuisines", description = "Returns all distinct cuisines.")
    @GetMapping("/v1/cuisines")
    public ResponseEntity<List<String>> getAllCuisines(){

        return restaurantService.getAllCuisines();

    }

    @ExceptionHandler(Exception.class)
    @Operation(summary = "Get opening timings", description = "Returns configured restaurant opening time range or examples.")
    @GetMapping("/v1/open-time")
    public ResponseEntity<List<LocalTime>> getOpeningTimings(){

        return restaurantService.getOpeningTimings();

    }

    @ExceptionHandler(Exception.class)
    @Operation(summary = "Get closing timings", description = "Returns configured restaurant closing time range or examples.")
    @GetMapping("/v1/close-time")
    public ResponseEntity<List<LocalTime>> getClosingTimings(){

        return restaurantService.getClosingTimings();

    }
}
