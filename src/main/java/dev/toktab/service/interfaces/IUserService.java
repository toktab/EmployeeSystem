package dev.toktab.service.interfaces;

import dev.toktab.model.User;
import dev.toktab.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {
    abstract List<User> sort();
}
