package com.example.khana_khazana.controller;

import com.example.khana_khazana.dto.users.request.UsersCreate;
import com.example.khana_khazana.dto.users.request.UsersEmail;
import com.example.khana_khazana.dto.users.request.UsersPhone;
import com.example.khana_khazana.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("v1/signup")
    public ResponseEntity<?> createNewUser(@RequestBody UsersCreate request) {
        try{
            return ResponseEntity.ok(usersService.createNewUser(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PostMapping("v1/signin/phone-number")
    public ResponseEntity<?> signInPhone(@RequestBody UsersPhone request){
        try {
            return usersService.signInPhone(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PostMapping("v1/signin/email")
    public ResponseEntity<?> signInEmail(@RequestBody UsersEmail request){
        try {
            return usersService.signInEmail(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/email")
    public ResponseEntity<?> updateEmail(@PathVariable Long id,@RequestBody UsersEmail request){
        try {
            return usersService.updateEmail(id,request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("v1/{id}/update/phone-number")
    public ResponseEntity<?> updatePhone(@PathVariable Long id,@RequestBody UsersPhone request){
        try {
            return usersService.updatePhone(id,request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("v1/{id}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable Long id,@RequestParam String password){
        try {
            return ResponseEntity.ok().body(usersService.deleteUser(id,password));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

}
