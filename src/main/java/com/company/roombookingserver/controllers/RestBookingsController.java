package com.company.roombookingserver.controllers;

import com.company.roombookingserver.model.entities.Booking;
import com.company.roombookingserver.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class RestBookingsController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/{date}")
    public List<Booking> getBookingsByDate(@PathVariable("date") String date) {
        return bookingRepository.findAllByDate(Date.valueOf(date));
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id){
        bookingRepository.deleteById(id);
    }

}
