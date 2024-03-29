package com.example.gip5team5api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*", allowCredentials = "true")
public class UserRestController {

    @Autowired
    public UserService userService;

    @PutMapping("user/update/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user){
        userService.updateUser(id,user);
        return user;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("user/adduser")
    public User addUser(@RequestBody User user){
        user.setRole("USER");
        userService.addUser(user);
        return user;
    }

    @PostMapping("user/addadmin")
    public User addAdmin(@RequestBody User user){
        user.setRole("ADMIN");
        userService.addAdmin(user);
        return user;
    }

    @PutMapping("user/promoteAdmin/{id}")
    public void PromoteAddmin(@PathVariable long id){
        userService.promoteAdmin(id);
    }

    @PutMapping("user/demoteAdmin/{id}")
    public void DemoteAddmin(@PathVariable long id){
        userService.demoteAdmin(id);
    }

    @GetMapping("user/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @RequestMapping("user/getall")
    public Iterable<User> getUsers() { return userService.findAll(); }

    @DeleteMapping("user/delete/{id}")
    public void removeUser(@PathVariable long id) {
        userService.removeUser(userService.findById(id).get());
    }

}

