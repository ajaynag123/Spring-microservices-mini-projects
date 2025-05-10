package com.mini_projects.user_service.domain.user.controller;

import com.mini_projects.user_service.domain.user.dto.UserDTO;
import com.mini_projects.user_service.domain.user.service.DevOnlyService;
import com.mini_projects.user_service.domain.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final DevOnlyService devOnlyService;

    public UserController(UserService userService, @Autowired(required = false) DevOnlyService devOnlyService) {
        this.userService = userService;
        this.devOnlyService = devOnlyService;
    }

    @PostMapping
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return userService.getWelcomeMessage();
    }

    @GetMapping("/dev-message")
    public String getDevMessage() {
        if (devOnlyService == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dev-only endpoint not available in this profile");
        }
        return devOnlyService.getDevOnlyMessage();
    }
}