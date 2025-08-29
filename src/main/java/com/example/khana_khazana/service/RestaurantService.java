package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.restaurant.request.RestaurantCreate;
import com.example.khana_khazana.entity.Restaurant;
import com.example.khana_khazana.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    //creation
    public String createNewRestaurant(RestaurantCreate request) {
        Restaurant newRestaurant = Restaurant.builder()
                .name(request.name())
                .address(request.address())
                .cuisine(request.cuisine())
                .openTime(request.openTime())
                .closeTime(request.closeTime())
                .build();
        restaurantRepository.save(newRestaurant);
        return "New restaurant created successfully.";
    }


    //updation
//    public ResponseEntity<?> updateNumberOfTables(Long id, Integer newNumberOfTables) {
//        return null;
//    }

    public ResponseEntity<?> updateCloseTime(Long id, LocalTime newCloseTime) {int status= restaurantRepository.updateCloseTime(id,newCloseTime);
        String successMsg="Closing Time updated successfully.";
        String failureMsg="Restaurant not found.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public ResponseEntity<?> updateOpenTime(Long id, LocalTime newOpenTime) {int status= restaurantRepository.updateOpenTime(id,newOpenTime);
        String successMsg="Opening Time updated successfully.";
        String failureMsg="Restaurant not found.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public ResponseEntity<?> updateCuisine(Long id, String newCuisine) {int status= restaurantRepository.updateCuisine(id,newCuisine);
        String successMsg="Cuisine updated successfully.";
        String failureMsg="Restaurant not found.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public ResponseEntity<?> updateAddress(Long id, String newAddress) {int status= restaurantRepository.updateAddress(id,newAddress);
        String successMsg="Address updated successfully.";
        String failureMsg="Restaurant not found.";
        return updateMsg(status,successMsg,failureMsg);
    }


    //Results
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getAllRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findByCuisine(cuisine);
    }

    public List<Restaurant> getAllRestaurantsByOpenTime(LocalTime openTime) {
        return restaurantRepository.findByOpenTime(openTime);
    }

    public List<Restaurant> getAllRestaurantsByCloseTime(LocalTime closeTime) {
        return restaurantRepository.findByCloseTime(closeTime);
    }

    public List<Restaurant> getAllRestaurantsByNumberOfTables(Integer numberOfTables) {
        return restaurantRepository.findByNumberOfTables(numberOfTables);
    }

    public List<Restaurant> getAllRestaurantsByName(String name) {
        return restaurantRepository.findByName(name);
    }

    public Optional<Restaurant> getRestaurantById(Long restId) {
        return restaurantRepository.findById(restId);
    }

    //filters
    public List<String> getAllCuisines() {
        return restaurantRepository.findDistinctCuisines();
    }

    public List<LocalTime> getOpeningTimings() {
        return restaurantRepository.findDistinctOpenTime();
    }

    public List<LocalTime> getClosingTimings() {
        return restaurantRepository.findDistinctCloseTime();
    }

    public List<Integer> getNumberOfTables() {
        return restaurantRepository.findDistinctNumberOfTables();
    }

    public String deleteRestaurant(Long restId) {
        restaurantRepository.deleteById(restId);
        return "Data of restaurant deleted.";
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
}
