package com.example.khana_khazana.repository;

import com.example.khana_khazana.entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCuisine(String cuisine);

    List<Restaurant> findByOpenTime(LocalTime openTime);

    List<Restaurant> findByCloseTime(LocalTime closeTime);

    List<Restaurant> findByNumberOfTables(Integer numberOfTables);

    List<Restaurant> findByName(String name);

    @Query("SELECT DISTINCT r.cuisine FROM Restaurant r")
    List<String> findDistinctCuisines();

    @Query("SELECT DISTINCT r.openTime FROM Restaurant r")
    List<LocalTime> findDistinctOpenTime();

    @Query("SELECT DISTINCT r.closeTime FROM Restaurant r")
    List<LocalTime> findDistinctCloseTime();

    @Query("SELECT DISTINCT r.numberOfTables FROM Restaurant r")
    List<Integer> findDistinctNumberOfTables();

    @Transactional
    @Modifying
    @Query("UPDATE Restaurant r SET r.openTime =: newOpenTime WHERE restId =:id")
    int updateOpenTime(@Param("id") Long id,@Param("newOpenTime") LocalTime newOpenTime);

    @Transactional
    @Modifying
    @Query("UPDATE Restaurant r SET r.closeTime =: newCloseTime WHERE restId = :id")
    int updateCloseTime(@Param("id") Long id,@Param("newCloseTime") LocalTime newCloseTime);

    @Transactional
    @Modifying
    @Query("UPDATE Restaurant r SET r.cuisine =: newCuisine WHERE restId = :id")
    int updateCuisine(@Param("id") Long id,@Param("newCuisine") String newCuisine);

    @Transactional
    @Modifying
    @Query("UPDATE Restaurant r SET r.address =: newAddress WHERE restId = :id")
    int updateAddress(@Param("id") Long id,@Param("newAddress") String newAddress);

    @Transactional
    @Modifying
    @Query("UPDATE Restaurant r SET r.numberOfTables = (SELECT COUNT(t) FROM Tables t WHERE t.restaurant.restId = :id) WHERE r.restId = :id")
    void updateNumberOfTables(@Param("id") Long id);

}
