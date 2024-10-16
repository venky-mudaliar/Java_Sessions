package com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.exceptions.ResourceNotFoundException;
import com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Temporary list to simulate a database
    private List<User> users = new ArrayList<>();

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
    	System.out.println("--------getAllUsers request--------");
        return users;
    }

    // GET a specific user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
    	System.out.println("--------getUserById request--------");
    	for (User user : users) {
            if (user.getId().equals(id)) {
                return user; // Return if user is found
            }
        }

        // Throw exception if no user is found after checking all
        throw new ResourceNotFoundException("User not found with id: " + id);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
    	System.out.println("--------ResourceNotFoundException request--------: Message:"+ex.getMessage());
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // POST to create a new user
    @PostMapping(consumes = { "application/json", "application/xml" })
    public User createUser(@RequestBody User newUser) {
    	System.out.println("--------createUser request--------");
    	//if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
            //throw new IllegalArgumentException("Email cannot be null or empty");
        //}
        users.add(newUser);
        return newUser;
    }

    // PUT to update an existing user
    @PutMapping(value = "/{id}", consumes = { "application/json", "application/xml" })
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    	System.out.println("--------updateUser request--------");
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setFirstName(updatedUser.getFirstName());
                user.setLastName(updatedUser.getLastName());
                user.setEmail(updatedUser.getEmail());
                return user;
            }
        }
        return null;
    }

    // DELETE a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
    	System.out.println("--------deleteUser request--------");
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.remove(i);
                break;
            }
        }
     // Throw exception if no user is found after checking all
        throw new ResourceNotFoundException("User not found with id: " + id);
    }
}