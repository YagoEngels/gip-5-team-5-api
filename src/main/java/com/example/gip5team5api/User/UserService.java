package com.example.gip5team5api.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*public User findByEmail(String email){

        List<User> userList = userRepository.findAll();
        User uit = new User();

        for (User currentUser : userList){
            if (currentUser.getEmail().equals(email)){
                uit = currentUser;
            }
        }
        return uit;
    }

     */
    public List<User> findAll() { return userRepository.findAll(); }

    public User updateUser(long id, User _user) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setFirstname(_user.getFirstname());
            user.get().setLastname(_user.getLastname());
            user.get().setEmail(_user.getEmail());
            user.get().setBirthdate(_user.getBirthdate());
            user.get().setRole(_user.getRoles());
            user.get().setPassword(_user.getPassword());
            userRepository.save(user.get());
            return user.get();
        }
        throw new IllegalArgumentException("User already exists");
    }

    public void addUser(User user){
        List<User> userList = userRepository.findAll();
        for (User currentUser : userList){
            if (currentUser.getEmail().equals(user.getEmail())){
                throw new IllegalArgumentException("User already exists");
            }
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public void addAdmin(User user){
        List<User> userList = userRepository.findAll();
        for (User currentUser : userList){
            if (currentUser.getEmail().equals(user.getEmail())){
                throw new IllegalArgumentException("User already exists");
            }
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void promoteAdmin(long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setRole("ADMIN");
        }
        userRepository.save(user.get());
    }
    public void demoteAdmin(long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setRole("USER");
        }
        userRepository.save(user.get());
    }
    public Optional<User> findById(long id) { return userRepository.findById(id); }
    public Optional<User> findByEmail(String e) { return userRepository.findByEmail(e); }

    public void removeUser(User user){ userRepository.delete(user); }
}
