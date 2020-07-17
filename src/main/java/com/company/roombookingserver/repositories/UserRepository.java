package com.company.roombookingserver.repositories;

import com.company.roombookingserver.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
