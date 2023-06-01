package dev.toktab.controller;

import dev.toktab.model.Type;
import dev.toktab.repository.TypeRepository;
import dev.toktab.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/types")
public class TypeController {
    @Autowired
    private TypeRepository typeRepository;
    TypeService typeService = new TypeService();

    @GetMapping("/get")
    public List<Type> getAllTypes() {
        return typeService.get();
    }

    @PostMapping()
    public Type createType(@RequestBody Type type) {
        return typeService.create(type);
    }

    @GetMapping("{id}")
    public ResponseEntity<Type> getTypeId(@PathVariable long id) {
        return typeService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Type> updateType(@PathVariable long id, @RequestBody Type typeDetails) {
        return typeService.update(id, typeDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteType(@PathVariable long id) {
        return typeService.delete(id);
    }
}
