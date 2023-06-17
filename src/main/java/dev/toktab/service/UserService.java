package dev.toktab.service;

import dev.toktab.model.User;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService extends BaseService<User> implements IUserService {
    private UserRepository userRepository;

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
    public boolean userExists(long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user==null) return false;
        else return true;
    }
    @Override
    public long getUserIdByUsername(String username){
        User user = userRepository.getUserByName(username).orElse(null);
        return user.getId();
    }

    @Override
    public boolean register(String username, String password) {
        User registeredUser = new User();
        registeredUser.setDate(Date.valueOf(LocalDate.now()));
        registeredUser.setName(username);
        registeredUser.setPassword(bCryptPasswordEncoder.encode(password));
        registeredUser.setType_id(1);//default worker
        userRepository.save(registeredUser);
        return true;
    }


}
