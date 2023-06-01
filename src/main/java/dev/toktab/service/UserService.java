package dev.toktab.service;

import dev.toktab.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public List<User> get();
    public User create(User user);
    public ResponseEntity<User> get(long id);
    public ResponseEntity<User> update(long id, User userDetails);
    public boolean delete(long id);
}
