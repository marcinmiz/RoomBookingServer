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
    public void deleteBooking(@PathVariable("id") Long id) {
        bookingRepository.deleteById(id);
    }

    @GetMapping()
    public Booking getBooking(@RequestParam("id") Long id) {
        return bookingRepository.findById(id).get();
    }

    @PutMapping()
    public Booking updateBooking(@RequestBody Booking booking){
//        Booking originalBooking = bookingRepository.findById(booking.getId()).get();
//        originalBooking.setUser(booking.getUser());
//        originalBooking.setRoom(booking.getRoom());
//        originalBooking.setLayout(booking.getLayout());
//        originalBooking.setDate(booking.getDate());
//        originalBooking.setStartTime(booking.getStartTime());
//        originalBooking.setEndTime(booking.getEndTime());
//        originalBooking.setParticipants(booking.getParticipants());
//        originalBooking.setTitle(booking.getTitle());
        System.out.println(booking.getLayout());

        return bookingRepository.save(booking);
    }
    @PostMapping()
    public Booking newBooking(@RequestBody Booking booking){
        System.out.println(booking.getLayout());
        return bookingRepository.save(booking);
    }

}
