package com.example.gip5team5api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UserRestController {

    @Autowired
    public UserService userService;

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user){
        userService.updateUser(id,user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        userService.addUser(user);
        return user;
    }

    @GetMapping("user/{id}")
    public Optional<User> getUserById(@PathVariable long id) { return userService.findById(id); }


    @RequestMapping("/user")
    public Iterable<User> getUsers() { return userService.findAll(); }

    @DeleteMapping("/user/{id}")
    public void removeUser(@PathVariable long id) {
        userService.removeUser(userService.findById(id).get());
    }

}

