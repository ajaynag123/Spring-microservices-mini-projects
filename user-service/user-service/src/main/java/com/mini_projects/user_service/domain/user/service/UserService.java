package com.mini_projects.user_service.domain.user.service;

import com.mini_projects.user_service.domain.user.dto.UserDTO;
import com.mini_projects.user_service.domain.user.mapper.UserMapper;
import com.mini_projects.user_service.domain.user.model.User;
import com.mini_projects.user_service.domain.user.repository.UserRepository;
import com.mini_projects.user_service.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDTO getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with ID" + id + "Not Found"));
        return userMapper.toDto(user);
    }
}
