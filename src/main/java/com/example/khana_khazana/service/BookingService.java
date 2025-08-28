package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.booking.request.BookingCreate;
import com.example.khana_khazana.entity.Booking;
import com.example.khana_khazana.entity.BookingStatus;
import com.example.khana_khazana.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    public ResponseEntity<?> updatePeople(Long id, Integer newPeople) {
        int status = bookingRepository.updatePeople(id,newPeople);
        String successMsg="No of People Updated successfully.";
        String failureMsg="Unable to update no of people.";
        return updateMsg(status , successMsg,failureMsg);
    }

    public ResponseEntity<?> updateStatus(Long id, BookingStatus newStatus) {int status = bookingRepository.updateStatus(id,newStatus);
        String successMsg="Status Updated successfully.";
        String failureMsg="Unable to update Status.";
        return updateMsg(status , successMsg,failureMsg);
    }

    public ResponseEntity<?> updateCloseTime(Long id, LocalTime newCloseTime) {int status = bookingRepository.updateCloseTime(id,newCloseTime);
        String successMsg="Closing Time Updated successfully.";
        String failureMsg="Unable to update Closing Time.";
        return updateMsg(status , successMsg,failureMsg);
    }

    public ResponseEntity<?> updateOpenTime(Long id, LocalTime newOpenTime) {int status = bookingRepository.updateOpenTime(id,newOpenTime);
        String successMsg="Opening Time Updated successfully.";
        String failureMsg="Unable to update Opening Time.";
        return updateMsg(status , successMsg,failureMsg);
    }

    public ResponseEntity<?> createNewBooking(BookingCreate request){
        int status =bookingRepository.createBooking(request.restId(),request.userId(),request.openTime(),request.closeTime(),request.status(), request.people());
        String failureMsg="Booking already Exists.";
        String successMsg="Booking created Successfully.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public List<Booking> getAllBookingsByNoOfPeople(Integer people) {return bookingRepository.findByPeople(people);
    }

    public List<Booking>  getAllBookingsByStatus(BookingStatus status) {return bookingRepository.findByStatus(status);
    }

    public List<Booking>  getAllBookingsByCloseTime(LocalDateTime closeTime) {return bookingRepository.findByCloseTime(closeTime);
    }

    public List<Booking>  getAllBookingsByOpenTime(LocalDateTime openTime) {return bookingRepository.findByOpenTime(openTime);
    }

    public List<Booking>  getAllBookingsByRestaurant(Long id) {return bookingRepository.findByRestaurantRestId(id);
    }

    public List<Booking> getAllBookingsByUser(Long id) {return bookingRepository.findByUserUserId(id);
    }

    private ResponseEntity<?> updateMsg(int status ,String successMsg,String failureMsg){
        if(status>0){
            return ResponseEntity.ok(successMsg);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureMsg);
        }
    }
}
