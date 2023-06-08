package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.User;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.interfaces.IUserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService extends BaseService<User> implements IUserService {
    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> sort() {
        List<User> userList= super.get();
        userList.sort(Comparator.comparing(User::getId));
        return userList;
    }
}
