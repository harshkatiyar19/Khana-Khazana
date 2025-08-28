package com.example.khana_khazana.controller;

import com.example.khana_khazana.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tables")
public class TablesController {
    @Autowired
    private TablesService tablesService;

    //creation
    @PostMapping("v1/new/{rest_id}")
    public ResponseEntity<?> createNewTable(@PathVariable  Long rest_id,@RequestParam Integer seats) {
        try{
            return tablesService.createNewTable(rest_id,seats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("v1/allTables/{rest_id}")
    public ResponseEntity<?> getAllTablesByRestaurants(@PathVariable  Long rest_id) {
        try{
            return ResponseEntity.ok(tablesService.getAllTablesByRestaurants(rest_id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("v1/tables/{id}")
    public ResponseEntity<?> getTableById(@PathVariable  Long id) {
        try{
            return ResponseEntity.ok(
                    tablesService.getTableById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("v1/allTablesBySeats")
    public ResponseEntity<?> getAllTablesBySeats(@PathVariable  Integer seats) {
        try{
            return ResponseEntity.ok(tablesService.getAllTablesBySeats(seats));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("v1/allTables/{tableId}")
    public ResponseEntity<?> deleteTable(@PathVariable  Long tableId) {
        try{
            return tablesService.deleteTable(tableId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    //updation
    @PatchMapping("v1/{id}/update/no-of-seats")
    public ResponseEntity<?> updateSeats(@PathVariable Long id, @RequestParam Integer newSeats){
        try {
            return tablesService.updateSeats(id,newSeats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
