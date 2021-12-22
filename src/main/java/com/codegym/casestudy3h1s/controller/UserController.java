package com.codegym.casestudy3h1s.controller;

import com.codegym.casestudy3h1s.model.User;
import com.codegym.casestudy3h1s.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if(!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editProduct(@PathVariable Long id, @RequestBody User user) {
        Optional<User> productOptional = userService.findById(id);
        if(!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if(user.getId() != null) {
                user.setId(id);
            }
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }
    }
}
