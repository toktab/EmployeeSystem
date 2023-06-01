package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.User;
import dev.toktab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> get() {

        return userRepository.findAll();
    }
    public User create(User user){
        return userRepository.save(user);
    }
    public ResponseEntity<User> get(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceException("User Not Found With the following ID -> " + id));
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<User> update(long id, User userDetails){
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

    public boolean delete(long id) {
        User deleteUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceException("User Not Found With the following ID -> " + id));
        userRepository.delete(deleteUser);

        return true;
    }
}
