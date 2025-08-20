package com.example.khana_khazana.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TablesService {
    public ResponseEntity<?> updateSeats(Long id, Integer newSeats) {return null;
    }

    public ResponseEntity<?> createNewTable( Long rest_id, Integer seats) {return null;
    }

    public ResponseEntity<?> getAllTablesByRestaurants(Long restId) {return null;
    }

    public ResponseEntity<?> getTableById(Long id) {return null;
    }

    public ResponseEntity<?> getAllTablesBySeats(Integer seats) {return null;
    }

    public ResponseEntity<?> deleteTable(Long tableId) {return null;
    }
}
