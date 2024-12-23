package com.example.course.resources;

import com.example.course.entities.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Nine", "nine@gmail.com", "99999-9999", "nine99");
        return ResponseEntity.ok().body(u);
    }
}
