package com.example.khana_khazana.controller;

import com.example.khana_khazana.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tables")
@Tag(name = "Tables", description = "Restaurant tables creation, update, delete, and query APIs")
public class TablesController {
	@Autowired
	private TablesService tablesService;

	//creation
	@Operation(summary = "Create new table for restaurant", description = "Creates a table for a restaurant with specified number of seats. Returns created table details.")
	@PostMapping("v1/new/{rest_id}")
	public ResponseEntity<?> createNewTable(@Parameter(description = "Restaurant id") @PathVariable  Long rest_id,@Parameter(description = "Number of seats") @RequestParam Integer seats) {
		try{
			return tablesService.createNewTable(rest_id,seats);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "List tables for restaurant", description = "Returns all tables for a restaurant id.")
	@GetMapping("v1/allTables/{rest_id}")
	public ResponseEntity<?> getAllTablesByRestaurants(@Parameter(description = "Restaurant id") @PathVariable  Long rest_id) {
		try{
			return ResponseEntity.ok(tablesService.getAllTablesByRestaurants(rest_id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Get table by id", description = "Returns a table details by id.")
	@GetMapping("v1/tables/{id}")
	public ResponseEntity<?> getTableById(@Parameter(description = "Table id") @PathVariable  Long id) {
		try{
			return ResponseEntity.ok(
					tablesService.getTableById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "List tables by seats", description = "Returns all tables that have the given number of seats.")
	@GetMapping("v1/allTablesBySeats")
	public ResponseEntity<?> getAllTablesBySeats(@Parameter(description = "Number of seats filter") @PathVariable  Integer seats) {
		try{
			return ResponseEntity.ok(tablesService.getAllTablesBySeats(seats));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@Operation(summary = "Delete table", description = "Deletes a table by id. Returns deletion result.")
	@DeleteMapping("v1/allTables/{tableId}")
	public ResponseEntity<?> deleteTable(@Parameter(description = "Table id") @PathVariable  Long tableId) {
		try{
			return tablesService.deleteTable(tableId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	//updation
	@Operation(summary = "Update table seats", description = "Updates number of seats for a table by id. Returns update result.")
	@PatchMapping("v1/{id}/update/no-of-seats")
	public ResponseEntity<?> updateSeats(@Parameter(description = "Table id") @PathVariable Long id, @Parameter(description = "New number of seats") @RequestParam Integer newSeats){
		try {
			return tablesService.updateSeats(id,newSeats);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
}
