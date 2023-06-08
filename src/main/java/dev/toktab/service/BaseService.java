package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.User;
import dev.toktab.model.interfaces.IEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseService<T extends IEntity> implements IService<T>{
    private final JpaRepository<T, Long> repository;

    @Override
    public List<T> get() {
        return repository.findAll();
    }

    @Override
    public T create(T t) {
        return repository.save(t);
    }

    @Override
    public ResponseEntity<T> get(long id) {
        T t = repository.findById(id)
                .orElseThrow(() -> new ResourceException("Model Not Found With the following ID -> " + id));
        return ResponseEntity.ok(t);
    }

    @Override
    public ResponseEntity<T> update(T details) {

        var entityFromRepo = repository.findById(details.getId()).orElseThrow(() -> new ResourceException("Error404"));

        entityFromRepo.memberWiseUpdate(details);
        var result = repository.save(entityFromRepo);

        return ResponseEntity.ok(result);
    }

    @Override
    public boolean delete(long id) {
        var entityFromRepo = repository.findById(id).orElse(null);
        if(entityFromRepo==null){
            return false;
        }
        repository.delete(entityFromRepo);

        return true;
    }
}
