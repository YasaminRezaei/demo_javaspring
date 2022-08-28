package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        userRepository.save(user);
        LOGGER.debug("user is saved! : {}",user);
    }

    @GetMapping("/users/{userid}")
    public User getUserById(@PathVariable int userid){
         final Optional<User> user = userRepository.findById(userid);
         if (user.isPresent()){
             LOGGER.debug("user ist {}",user.get());
             return user.get();
         }
         else {
             LOGGER.debug("user is not found");
             return null;
         }

    }
    @GetMapping("users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
    @DeleteMapping("/users/{userid}")
    public void deleteUser(@PathVariable int userid){
        if (userRepository.existsById(userid)){
            userRepository.deleteById(userid);
            LOGGER.debug("user with id {} is deleted",userid);
        }
        else
        {
            LOGGER.debug("user is not found");
        }

    }
}
