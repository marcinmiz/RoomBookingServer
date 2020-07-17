package com.company.roombookingserver.repositories;

import com.company.roombookingserver.model.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
