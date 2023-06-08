package dev.toktab.service;

import dev.toktab.model.User;
import dev.toktab.model.interfaces.IEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IService<T extends IEntity> {
    public List<T> get();

    public T create(T t);

    public ResponseEntity<T> get(long id);

    public ResponseEntity<T> update(T details);

    public boolean delete(long id);
}
