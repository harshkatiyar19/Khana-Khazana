package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.booking.request.BookingUpdation;
import com.example.khana_khazana.dto.restaurant.request.RestaurantCreate;
import com.example.khana_khazana.dto.restaurant.request.RestaurantUpdation;
import com.example.khana_khazana.entity.Restaurant;
import com.example.khana_khazana.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    //creation
    public ResponseEntity<String> createNewRestaurant(RestaurantCreate request) {
        Restaurant newRestaurant = Restaurant.builder()
                .name(request.name())
                .address(request.address())
                .cuisine(request.cuisine())
                .openTime(request.openTime())
                .closeTime(request.closeTime())
                .imgUrl(request.imgUrl())
                .build();
        restaurantRepository.save(newRestaurant);
        return ResponseEntity.ok("New restaurant created successfully.");
    }


    //updation
//    public ResponseEntity<?> updateNumberOfTables(Long id, Integer newNumberOfTables) {
//        return null;
//    }

//    public ResponseEntity<?> updateCloseTime(Long id, LocalTime newCloseTime) {int status= restaurantRepository.updateCloseTime(id,newCloseTime);
//        String successMsg="Closing Time updated successfully.";
//        String failureMsg="Restaurant not found.";
//        return updateMsg(status,successMsg,failureMsg);
//    }
//
//    public ResponseEntity<?> updateOpenTime(Long id, LocalTime newOpenTime) {int status= restaurantRepository.updateOpenTime(id,newOpenTime);
//        String successMsg="Opening Time updated successfully.";
//        String failureMsg="Restaurant not found.";
//        return updateMsg(status,successMsg,failureMsg);
//    }
//
//    public ResponseEntity<?> updateCuisine(Long id, String newCuisine) {int status= restaurantRepository.updateCuisine(id,newCuisine);
//        String successMsg="Cuisine updated successfully.";
//        String failureMsg="Restaurant not found.";
//        return updateMsg(status,successMsg,failureMsg);
//    }
//
//    public ResponseEntity<?> updateAddress(Long id, String newAddress) {int status= restaurantRepository.updateAddress(id,newAddress);
//        String successMsg="Address updated successfully.";
//        String failureMsg="Restaurant not found.";
//        return updateMsg(status,successMsg,failureMsg);
//    }


    //Results
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok().body(restaurantRepository.findAll());
    }

    public ResponseEntity<List<Restaurant>> getAllRestaurantsByCuisine(String cuisine) {
        return ResponseEntity.ok().body(restaurantRepository.findByCuisine(cuisine));
    }

    public ResponseEntity<List<Restaurant>> getAllRestaurantsByOpenTime(LocalTime openTime) {
        return ResponseEntity.ok().body(restaurantRepository.findByOpenTime(openTime));
    }

    public ResponseEntity<List<Restaurant>> getAllRestaurantsByCloseTime(LocalTime closeTime) {
        return ResponseEntity.ok().body(restaurantRepository.findByCloseTime(closeTime));
    }

    public ResponseEntity<List<Restaurant>> getAllRestaurantsByNumberOfTables(Integer numberOfTables) {
        return ResponseEntity.ok().body(restaurantRepository.findByNumberOfTables(numberOfTables));
    }

    public ResponseEntity<List<Restaurant>> getAllRestaurantsByName(String name) {
        return ResponseEntity.ok().body(restaurantRepository.findByName(name));
    }

    public ResponseEntity<Optional<Restaurant>> getRestaurantById(Long restId) {
        return ResponseEntity.ok().body(restaurantRepository.findById(restId));
    }

    //filters
    public ResponseEntity<List<String>> getAllCuisines() {
        return ResponseEntity.ok().body(restaurantRepository.findDistinctCuisines());
    }

    public ResponseEntity<List<LocalTime>> getOpeningTimings() {
        return ResponseEntity.ok().body(restaurantRepository.findDistinctOpenTime());
    }

    public ResponseEntity<List<LocalTime>> getClosingTimings() {
        return ResponseEntity.ok().body(restaurantRepository.findDistinctCloseTime());
    }

    public ResponseEntity<List<Integer>> getNumberOfTables() {
        return ResponseEntity.ok().body(restaurantRepository.findDistinctNumberOfTables());
    }

    public ResponseEntity<String> deleteRestaurant(Long restId) {
        restaurantRepository.deleteById(restId);
        return ResponseEntity.ok().body("Data of restaurant deleted.");
    }

    //helper functions
    private ResponseEntity<?> updateMsg(int status ,String successMsg,String failureMsg){
        if(status>0){
            return ResponseEntity.ok(successMsg);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMsg);
        }
    }


    public ResponseEntity<List<String>> updateRestaurant(Long id, RestaurantUpdation request) {
        List<String> updateMsg= new ArrayList<>();
        if(request.closeTime()!=null){
            String successMsg="Closing Time Updated successfully.";
            String failureMsg="Unable to update Closing Time.";
            int status =restaurantRepository.updateCloseTime(id,request.closeTime());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }
        if(request.openTime()!=null){
            String successMsg="Opening Time updated successfully.";
            String failureMsg="Restaurant not found.";
            int status =restaurantRepository.updateOpenTime(id,request.openTime());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }
        if(request.address()!=null){
            String successMsg="Address updated successfully.";
            String failureMsg="Restaurant not found.";
            int status =restaurantRepository.updateAddress(id,request.address());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }

        if(request.cuisine()!=null){
            String successMsg="Cuisine updated successfully.";
            String failureMsg="Restaurant not found.";
            int status =restaurantRepository.updateCuisine(id,request.cuisine());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }
        return ResponseEntity.ok(updateMsg);
    }

}
