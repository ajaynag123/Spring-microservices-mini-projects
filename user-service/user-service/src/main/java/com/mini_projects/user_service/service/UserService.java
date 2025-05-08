package com.mini_projects.user_service.service;

import com.mini_projects.user_service.dto.UserDTO;
import com.mini_projects.user_service.mapper.UserMapper;
import com.mini_projects.user_service.model.User;
import com.mini_projects.user_service.repository.UserRepository;
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
        return userMapper.toUserDTO(savedUser);
    }

    public UserDTO getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
        return userMapper.toUserDTO(user);
    }
}
