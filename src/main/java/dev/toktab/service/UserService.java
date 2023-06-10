package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Type;
import dev.toktab.model.User;
import dev.toktab.repository.SalaryHistoryRepository;
import dev.toktab.repository.TypeRepository;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.interfaces.IUserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService extends BaseService<User> implements IUserService {
    private UserRepository userRepository;

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        super.setRepository(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public List<User> sort() {
        return null;
    }
    @Override
    public boolean userExists(String username) {
        User user = userRepository.getUserByName(username).orElse(null);
        return user != null;
    }

    @Override
    public boolean register(String username, String password) {
        User registeredUser = new User();
        Type registeredType = typeRepository.findById((long) -1).orElseThrow();
        registeredUser.setDate(Date.valueOf(LocalDate.now()));
        registeredUser.setName(username);
        registeredUser.setPassword(bCryptPasswordEncoder.encode(password));
        registeredUser.setType(registeredType);
        userRepository.save(registeredUser);
        return true;
    }


}
