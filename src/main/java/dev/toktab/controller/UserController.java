package dev.toktab.controller;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.User;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.UserService;
import dev.toktab.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    UserService userService = new UserServiceImp();

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.get();
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserId(@PathVariable long id) {
        return userService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails) {
        return userService.update(id, userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable long id) {
        return userService.delete(id);
    }
}
