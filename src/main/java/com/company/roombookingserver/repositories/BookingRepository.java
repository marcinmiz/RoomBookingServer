package com.company.roombookingserver.repositories;

import com.company.roombookingserver.model.entities.Booking;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAllByDate(Date date);
}
