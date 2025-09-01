package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.booking.request.BookingCreate;
import com.example.khana_khazana.dto.booking.request.BookingUpdation;
import com.example.khana_khazana.entity.Booking;
import com.example.khana_khazana.entity.BookingStatus;
import com.example.khana_khazana.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;


    public ResponseEntity<String> createNewBooking(BookingCreate request){
        int status =bookingRepository.createBooking(request.restId(),request.userId(),request.openTime(),request.closeTime(),request.status(), request.people());
        String failureMsg="Booking already Exists.";
        String successMsg="Booking created Successfully.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public ResponseEntity<List<Booking>> getAllBookingsByNoOfPeople(Integer people) {
        return ResponseEntity.ok().body(bookingRepository.findByPeople(people));
    }

    public ResponseEntity<List<Booking>>  getAllBookingsByStatus(BookingStatus status) {
        return ResponseEntity.ok().body(bookingRepository.findByStatus(status));
    }

    public ResponseEntity<List<Booking>>  getAllBookingsByCloseTime(LocalDateTime closeTime) {
        return ResponseEntity.ok().body(bookingRepository.findByCloseTime(closeTime));
    }

    public ResponseEntity<List<Booking>>  getAllBookingsByOpenTime(LocalDateTime openTime) {
        return ResponseEntity.ok().body(bookingRepository.findByOpenTime(openTime));
    }

    public ResponseEntity<List<Booking>>  getAllBookingsByRestaurant(Long id) {
        return ResponseEntity.ok().body(bookingRepository.findByRestaurantRestId(id));
    }

    public ResponseEntity<List<Booking>> getAllBookingsByUser(Long id) {
        return ResponseEntity.ok().body(bookingRepository.findByUserUserId(id));
    }

    private ResponseEntity<String> updateMsg(int status ,String successMsg,String failureMsg){
        if(status>0){
            return ResponseEntity.ok(successMsg);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureMsg);
        }
    }

    public ResponseEntity<List<String>> updateBooking(Long id, BookingUpdation request) {
        List<String> updateMsg= new ArrayList<>();
        if(request.closeTime()!=null){
            String successMsg="Closing Time Updated successfully.";
            String failureMsg="Unable to update Closing Time.";
            int status =bookingRepository.updateCloseTime(id,request.closeTime());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }
        if(request.openTime()!=null){
            String successMsg="Opening Time Updated successfully.";
            String failureMsg="Unable to update Opening Time.";
            int status= bookingRepository.updateOpenTime(id,request.openTime());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }
        if(request.status()!=null) {
            String successMsg="Status Updated successfully.";
            String failureMsg="Unable to update Status.";
            int status= bookingRepository.updateStatus(id,request.status());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }
        if(request.people()!=null) {
            String successMsg="No of People Updated successfully.";
            String failureMsg="Unable to update no of people.";
            int status=bookingRepository.updatePeople(id,request.people());
            if(status>0){
                updateMsg.add(successMsg);
            }
            else{
                updateMsg.add(failureMsg);
            }
        }
        return ResponseEntity.ok(updateMsg);
    }
//    public ResponseEntity<String> updatePeople(Long id, Integer newPeople) {
//        int status = bookingRepository.updatePeople(id,newPeople);
//        String successMsg="No of People Updated successfully.";
//        String failureMsg="Unable to update no of people.";
//        return updateMsg(status , successMsg,failureMsg);
//    }
//
//    public ResponseEntity<String> updateStatus(Long id, BookingStatus newStatus) {int status = bookingRepository.updateStatus(id,newStatus);
//        String successMsg="Status Updated successfully.";
//        String failureMsg="Unable to update Status.";
//        return updateMsg(status , successMsg,failureMsg);
//    }
//
//    public ResponseEntity<String> updateCloseTime(Long id, LocalTime newCloseTime) {int status = bookingRepository.updateCloseTime(id,newCloseTime);
//        String successMsg="Closing Time Updated successfully.";
//        String failureMsg="Unable to update Closing Time.";
//        return updateMsg(status , successMsg,failureMsg);
//    }
//
//    public ResponseEntity<String> updateOpenTime(Long id, LocalTime newOpenTime) {int status = bookingRepository.updateOpenTime(id,newOpenTime);
//        String successMsg="Opening Time Updated successfully.";
//        String failureMsg="Unable to update Opening Time.";
//        return updateMsg(status , successMsg,failureMsg);
//    }
}
