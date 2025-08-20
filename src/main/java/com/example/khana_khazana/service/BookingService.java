package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.booking.BookingCreate;
import com.example.khana_khazana.entity.BookingStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class BookingService {
    public ResponseEntity<?> updatePeople(Long id, Integer newPeople) {return null;
    }

    public ResponseEntity<?> updateStatus(Long id, BookingStatus newStatus) {return null;
    }

    public ResponseEntity<?> updateCloseTime(Long id, LocalTime newCloseTime) {return null;
    }

    public ResponseEntity<?> updateOpenTime(Long id, LocalTime newOpenTime) {return null;
    }

    public ResponseEntity<?> createNewBooking(BookingCreate request) {return null;
    }

    public ResponseEntity<?> getAllBookingsByNoOfPeople(Integer people) {return null;
    }

    public ResponseEntity<?> getAllBookingsByStatus(BookingStatus status) {return null;
    }

    public ResponseEntity<?> getAllBookingsByCloseTime(LocalDateTime closeTime) {return null;
    }

    public ResponseEntity<?> getAllBookingsByOpenTime(LocalDateTime openTime) {return null;
    }

    public ResponseEntity<?> getAllBookingsByRestaurant(Long id) {return null;
    }

    public ResponseEntity<?> getAllBookingsByUser(Long id) {return null;
    }
}
