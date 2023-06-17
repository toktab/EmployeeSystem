package dev.toktab.service.interfaces;

import dev.toktab.model.User;
import dev.toktab.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {
    abstract List<User> sort();
    abstract boolean userExists(String username);
    abstract boolean userExists(long id);
    abstract boolean register(String username, String password);
    abstract long getUserIdByUsername(String username);
}
