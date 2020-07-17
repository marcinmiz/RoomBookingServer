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

    @GetMapping()
    public List<AngularUser> getAllUsers() throws InterruptedException {
        //Thread.sleep(3000);
        Iterable<User> list = userRepository.findAll();
        List<AngularUser> returnList = new ArrayList<>();
        for (User user:list) {
            returnList.add(new AngularUser(user));
        }
        return returnList;
    }

    @GetMapping("/{id}")
    public AngularUser getUser(@PathVariable("id") Long id) {
        System.out.println("Got a request for user" + id);
        return new AngularUser(userRepository.findById(id).get());
    }

    @PostMapping()
    public AngularUser newUser(@RequestBody User user) {
        return new AngularUser(userRepository.save(user));
    }

    @PutMapping()
    public AngularUser updateUser(@RequestBody AngularUser updatedUser) throws InterruptedException {
//        Thread.sleep(1000);
//        throw new RuntimeException("something went wrong");
        User originalUser = userRepository.findById(updatedUser.getId()).get();
        originalUser.setName(updatedUser.getName());
        return new AngularUser(userRepository.save(originalUser));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }

    @GetMapping("/resetPassword/{id}")
    public void resetPassword(@PathVariable("id") Long id){
        User user = userRepository.findById(id).get();
        user.setPassword("secret");
        userRepository.save(user);
    }

}
