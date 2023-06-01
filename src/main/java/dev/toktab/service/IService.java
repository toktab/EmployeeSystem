package dev.toktab.service;

import dev.toktab.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IService<T> {
    public List<T> get();
    public T create(T t);
    public ResponseEntity<T> get(long id);
    public ResponseEntity<T> update(long id, T details);
    public boolean delete(long id);
}
