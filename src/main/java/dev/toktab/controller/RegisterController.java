package dev.toktab.controller;

import dev.toktab.controller.model.RegistrationResponse;
import dev.toktab.model.User;
import dev.toktab.repository.UserRepository;
import dev.toktab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/register")
public class RegisterController {
    private final UserService userService;

    @GetMapping("{name}/{password}")
    public RegistrationResponse register(@PathVariable String name, @PathVariable String password) {
        if(userService.userExists(name)) return RegistrationResponse.fail("Username is already in use!");
        var result = userService.register(name, password);
        if(!result) return RegistrationResponse.fail("Error");
        return RegistrationResponse.ok("Successfully registered user!");
    }
}
