package dev.toktab.controller;

import dev.toktab.model.Type;
import dev.toktab.repository.TypeRepository;
import dev.toktab.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/types")
public class TypeController {
    private final TypeRepository typeRepository;
    @Autowired
    TypeService typeService;

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

    @PutMapping("/update")
    public ResponseEntity<Type> updateType(@RequestBody Type typeDetails) {
        return typeService.update(typeDetails);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteType(@PathVariable long id) {
        return typeService.delete(id);
    }
}
