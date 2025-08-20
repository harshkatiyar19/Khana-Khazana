package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.restaurant.RestaurantCreate;
import com.example.khana_khazana.dto.restaurant.RestaurantResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;

@Service
public class RestaurantService {
    //creation
    public ResponseEntity<?> createNewRestaurant(RestaurantCreate request) { return null;
    }


    //updation
    public ResponseEntity<?> updateNumberOfTables(Long id, Integer newNumberOfTables) {
        return null;
    }

    public ResponseEntity<?> updateCloseTime(Long id, LocalTime newCloseTime) {return null;
    }

    public ResponseEntity<?> updateOpenTime(Long id, LocalTime newOpenTime) {return null;
    }

    public ResponseEntity<?> updateCuisine(Long id, String newCuisine) {return null;
    }

    public ResponseEntity<?> updateAddress(Long id, String newAddress) {return null;
    }


    //Results
    public List<RestaurantResponse> getAllRestaurants() { return null;
    }

    public List<RestaurantResponse> getAllRestaurantsByCuisine(String cuisine) {return null;
    }

    public List<RestaurantResponse> getAllRestaurantsByOpenTime(LocalTime openTime) {return null;
    }

    public List<RestaurantResponse> getAllRestaurantsByCloseTime(LocalTime closeTime) {return null;
    }

    public List<RestaurantResponse> getAllRestaurantsByNumberOfTables(Integer numberOfTables) {return null;
    }

    public List<RestaurantResponse> getAllRestaurantsByName(String name) {return null;
    }

    public RestaurantResponse getRestaurantByName(Long restId) { return null;
    }

    //filters
    public List<String> getAllCuisines() {return null;
    }

    public List<LocalTime> getOpeningTimings() {return null;
    }

    public List<LocalTime> getClosingTimings() {return null;
    }

    public List<Integer> getNumberOfTables() {
        return null;
    }


    public String deleteRestaurant(Long restId) { return null;
    }
}
