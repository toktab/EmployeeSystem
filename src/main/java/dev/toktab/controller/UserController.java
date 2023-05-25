package dev.toktab.controller;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.User;
import dev.toktab.repository.UserRepository;
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
//
//    @Query(value = "select a.id as student_id, a.name as student_name, b.id, b.rank from user a\n" +
//            "join type b on a.id = b.id;", nativeQuery = true)
//    Collection<User> findAllActiveUsersNative() {
//        return null;
//    }

    //    @Query(value = "select a.id as student_id, a.name as student_name, b.id, b.rank from user a\n" +
//            "join type b on a.id = b.id;", nativeQuery = true)
    @GetMapping()
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
    //create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //getId
    @GetMapping("{id}")
    public ResponseEntity<User> getUserId(@PathVariable long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceException("User Not Found With the following ID -> " + id));
        return ResponseEntity.ok(user);
    }

    //updateUser
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails){
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceException("User Not Found With the following ID -> " + id));
        updateUser.setName(userDetails.getName());
        updateUser.setPassword(userDetails.getName());
        updateUser.setType(userDetails.getType());
        updateUser.setBudget(userDetails.getBudget());
        updateUser.setFired(userDetails.getFired());
        updateUser.setSalary(userDetails.getSalary());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }
}
