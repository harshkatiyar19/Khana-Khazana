package com.example.khana_khazana.repository;

import com.example.khana_khazana.entity.Tables;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TablesRepository extends JpaRepository<Tables, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO tables (rest_id, seats) VALUES (:restId, :seats)",
            nativeQuery = true)
    int createTableByRestId(@Param("restId") Long restId, @Param("seats") Integer seats);

    @Modifying
    @Transactional
    @Query("SELECT t.restaurant.restId FROM Tables t WHERE t.tableId = :tableId")
    Long findRestIdByTableId(@Param("tableId") Long tableId);
    
    @Modifying
    @Transactional
    @Query("UPDATE Tables t SET t.seats=:seats WHERE t.tableId=:id")
    int updateSeatsByTableId(@Param("id") Long tableId, @Param("seats") Integer seats);

    List<Tables> findByRestaurantRestId(Long restId);

    List<Tables> findBySeats(Integer seats);
}
