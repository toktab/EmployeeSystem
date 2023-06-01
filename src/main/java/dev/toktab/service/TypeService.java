package dev.toktab.service;

import dev.toktab.exception.ResourceException;
import dev.toktab.model.Type;
import dev.toktab.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements IService<Type>{

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> get() {
        return typeRepository.findAll();
    }

    public Type create(Type type) {
        return typeRepository.save(type);
    }

    public ResponseEntity<Type> get(long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Type Not Found With the following ID -> " + id));
        return ResponseEntity.ok(type);
    }

    public ResponseEntity<Type> update(long id, Type typeDetails) {
        Type updateType = typeRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Type Not Found With the following ID -> " + id));
        updateType.setCreatorId(typeDetails.getCreatorId());
        updateType.setRank(typeDetails.getRank());

        typeRepository.save(updateType);

        return ResponseEntity.ok(updateType);
    }

    public boolean delete(long id) {
        Type deleteType = typeRepository.findById(id)
                .orElseThrow(() -> new ResourceException("Type Not Found With the following ID -> " + id));
        typeRepository.delete(deleteType);

        return true;
    }
}
