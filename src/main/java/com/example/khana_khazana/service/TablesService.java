package com.example.khana_khazana.service;

import com.example.khana_khazana.entity.Tables;
import com.example.khana_khazana.repository.RestaurantRepository;
import com.example.khana_khazana.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesService {
    @Autowired
    TablesRepository tablesRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public ResponseEntity<?> updateSeats(Long tableId, Integer newSeats) {
        int status=tablesRepository.updateSeatsByTableId(tableId,newSeats);
        String successMsg="New table added successfully.";
        String failureMsg="Unable find restaurant to add table.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public ResponseEntity<?> createNewTable( Long rest_id, Integer seats) {
        int status = tablesRepository.createTableByRestId(rest_id,seats);
        String successMsg="New table added successfully.";
        String failureMsg="Unable find restaurant to add table.";
        if(status>0){
            restaurantRepository.updateNumberOfTables(rest_id);
            return ResponseEntity.ok(successMsg);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMsg);
        }
//        return updateMsg(status,successMsg,failureMsg);
    }

    public List<Tables> getAllTablesByRestaurants(Long restId) {return tablesRepository.findByRestaurantRestId(restId);
    }

    public Optional<Tables> getTableById(Long id) {return tablesRepository.findById(id);
    }

    public List<Tables> getAllTablesBySeats(Integer seats) {return tablesRepository.findBySeats(seats);
    }

    public ResponseEntity<?> deleteTable(Long tableId) {
        tablesRepository.deleteById(tableId);
        String successMsg="Table deleted successfully.";
        restaurantRepository.updateNumberOfTables(tablesRepository.findRestIdByTableId(tableId));
        return ResponseEntity.ok(successMsg);
    }
    //helper function
    private ResponseEntity<?> updateMsg(int status ,String successMsg,String failureMsg){
        if(status>0){
            return ResponseEntity.ok(successMsg);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMsg);
        }
    }
}
