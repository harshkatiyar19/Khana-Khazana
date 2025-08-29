package com.example.khana_khazana.repository;

import com.example.khana_khazana.entity.Booking;
import com.example.khana_khazana.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Transactional
    @Modifying
    @Query(value = """
    INSERT INTO bookings (rest_id, user_id, table_id, open_time, close_time, status, people)
    SELECT :restId, :userId, t.table_id, :openTime, :closeTime, :status, :people
    FROM (
        SELECT table_id
        FROM tables
        WHERE rest_id = :restId
          AND seats >= :people
        ORDER BY seats ASC
        LIMIT 1
    ) t
    WHERE NOT EXISTS (
        SELECT 1
        FROM bookings b
        WHERE b.table_id = t.table_id
          AND b.open_time < :closeTime
          AND b.close_time > :openTime
          AND b.status != 'cancelled'
    );
""", nativeQuery = true)
    int createBooking(
            @Param("restId") Long restId,
            @Param("userId") Long userId,
            @Param("openTime") LocalDateTime openTime,
            @Param("closeTime") LocalDateTime closeTime,
            @Param("status") BookingStatus status,
            @Param("people") int people
    );

    List<Booking> findByUserUserId(Long id);

    List<Booking> findByRestaurantRestId(Long id);

    List<Booking> findByOpenTime(LocalDateTime openTime);

    List<Booking> findByCloseTime(LocalDateTime closeTime);

    List<Booking> findByStatus(BookingStatus status);

    List<Booking> findByPeople(Integer people);

    @Transactional
    @Modifying
    @Query(value="""
            UPDATE bookings b
            SET
                people = :people,
                table_id = CASE
                    WHEN t.table_id IS NULL THEN b.table_id -- no new suitable table found, keep current
                    ELSE t.table_id -- new suitable table found
                END
            FROM (
                SELECT t.table_id
                FROM tables t
                WHERE t.rest_id = :restId
                  AND t.seats >= :people
                  AND t.table_id <> b.table_id
                  AND NOT EXISTS (
                    SELECT 1 FROM bookings pb
                    WHERE pb.table_id = t.table_id
                      AND pb.open_time < b.close_time
                      AND pb.close_time > b.open_time
                      AND pb.status != 'cancelled'
                  )
                ORDER BY t.seats ASC
                LIMIT 1
            ) AS t
            WHERE b.booking_id = :bookingId
              AND (
                b.table_id = t.table_id OR b.table.seats < :people
              );
            """,nativeQuery = true)
    int updatePeople(@Param("bookingId")Long bookingId,@Param("people") int people);

    @Transactional
    @Modifying
    @Query("UPDATE Booking b SET b.status=:newStatus WHERE b.bookingId=:bookingId")
    int updateStatus(@Param("bookingId")Long id,@Param("newStatus") BookingStatus newStatus);

    @Transactional
    @Modifying
    @Query(value="""
            UPDATE bookings b
            SET close_time = :newCloseTime
            WHERE b.booking_id = :bookingId
              AND NOT EXISTS (
                SELECT 1 FROM bookings pb
                WHERE pb.table_id = b.table_id
                  AND pb.booking_id <> :bookingId
                  AND pb.status != 'cancelled'
                  AND pb.open_time < :newCloseTime
                  AND pb.close_time > b.open_time
            );
            """,nativeQuery = true)
    int updateCloseTime(@Param("bookingId")Long id,@Param("newCloseTime") LocalTime newCloseTime);

    @Transactional
    @Modifying
    @Query(value="""
            UPDATE bookings b
            SET open_time = :newOpenTime
            WHERE b.booking_id = :bookingId
              AND NOT EXISTS (
                SELECT 1 FROM bookings pb
                WHERE pb.table_id = b.table_id
                  AND pb.booking_id != :bookingId
                  AND pb.status != 'cancelled'
                  AND pb.open_time < b.close_time
                  AND pb.close_time > :newOpenTime
              );
            
            """,nativeQuery = true)
    int updateOpenTime(@Param("bookingId")Long id,@Param("newOpenTime") LocalTime newOpenTime);
}
