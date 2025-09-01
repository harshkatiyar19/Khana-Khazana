package com.example.khana_khazana.controller;

import com.example.khana_khazana.service.TablesService;
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
@RequestMapping("/api/tables")
@Tag(name = "Tables", description = "Restaurant tables creation, update, delete, and query APIs")
public class TablesController {
	@Autowired
	private TablesService tablesService;

	//creation
    @ExceptionHandler(Exception.class)
	@Operation(summary = "Create new table for restaurant", description = "Creates a table for a restaurant with specified number of seats. Returns created table details.")
	@PostMapping("v1/new/{rest_id}")
	public ResponseEntity<?> createNewTable(@Parameter(description = "Restaurant id") @PathVariable  Long rest_id,@Parameter(description = "Number of seats") @RequestParam Integer seats) {

			return tablesService.createNewTable(rest_id,seats);

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "List tables for restaurant", description = "Returns all tables for a restaurant id.")
	@GetMapping("v1/allTables/{rest_id}")
	public ResponseEntity<?> getAllTablesByRestaurants(@Parameter(description = "Restaurant id") @PathVariable  Long rest_id) {

			return ResponseEntity.ok(tablesService.getAllTablesByRestaurants(rest_id));

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Get table by id", description = "Returns a table details by id.")
	@GetMapping("v1/tables/{id}")
	public ResponseEntity<?> getTableById(@Parameter(description = "Table id") @PathVariable  Long id) {

			return ResponseEntity.ok(
					tablesService.getTableById(id));

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "List tables by seats", description = "Returns all tables that have the given number of seats.")
	@GetMapping("v1/allTablesBySeats")
	public ResponseEntity<?> getAllTablesBySeats(@Parameter(description = "Number of seats filter") @PathVariable  Integer seats) {

			return ResponseEntity.ok(tablesService.getAllTablesBySeats(seats));

	}

    @ExceptionHandler(Exception.class)
	@Operation(summary = "Delete table", description = "Deletes a table by id. Returns deletion result.")
	@DeleteMapping("v1/allTables/{tableId}")
	public ResponseEntity<?> deleteTable(@Parameter(description = "Table id") @PathVariable  Long tableId) {

			return tablesService.deleteTable(tableId);

	}

	//updation
    @ExceptionHandler(Exception.class)
	@Operation(summary = "Update table seats", description = "Updates number of seats for a table by id. Returns update result.")
	@PatchMapping("v1/{id}/update/no-of-seats")
	public ResponseEntity<?> updateSeats(@Parameter(description = "Table id") @PathVariable Long id, @Parameter(description = "New number of seats") @RequestParam Integer newSeats){

			return tablesService.updateSeats(id,newSeats);
	}
}
