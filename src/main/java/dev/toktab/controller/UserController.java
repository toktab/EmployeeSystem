package dev.toktab.controller;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.User;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    UserService userService;

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

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User userDetails) {
        return userService.update(userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable long id) {
        return userService.delete(id);
    }
}
