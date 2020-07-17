package com.company.roombookingserver.controllers;

import com.company.roombookingserver.model.AngularUser;
import com.company.roombookingserver.model.entities.User;
import com.company.roombookingserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")

public class RestUserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<AngularUser> getAllUsers() throws InterruptedException {
        //Thread.sleep(3000);
        List<User> list = new ArrayList<>();
        Iterator<User> iterator = userRepository.findAll().iterator();
        if (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list.stream().map(AngularUser::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AngularUser getUser(@PathVariable("id") Long id) {
        System.out.println("Got a request for user" + id);
        return new AngularUser(userRepository.findById(id).get());
    }

    @PostMapping
    public AngularUser newUser(@RequestBody AngularUser user) {
        return new AngularUser(userRepository.save(user.asUser()));
    }

    @PutMapping
    public AngularUser updateUser(@RequestBody AngularUser updatedUser) {
        User originalUser = userRepository.findById(updatedUser.getId()).get();
        originalUser.setName(updatedUser.getName());
        return new AngularUser(userRepository.save(originalUser));
    }
}
