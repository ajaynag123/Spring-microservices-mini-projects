package com.mini_projects.user_service.controller;

import com.mini_projects.user_service.dto.UserDTO;
import com.mini_projects.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
      return   userService.createUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

}
