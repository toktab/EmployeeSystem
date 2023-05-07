package dev.toktab.controller;

import dev.toktab.model.Type;
import dev.toktab.model.User;
import dev.toktab.repository.TypeRepository;
import dev.toktab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/types")
@Component
public class TypeController {
    @Autowired
    private TypeRepository typeRepository;
//
//    @Query(value = "select a.id as student_id, a.name as student_name, b.id, b.rank from user a\n" +
//            "join type b on a.id = b.id;", nativeQuery = true)
//    Collection<User> findAllActiveUsersNative() {
//        return null;
//    }
    @GetMapping()
    public List<Type> getAllTypes(){

        return typeRepository.findAll();
    }
}
