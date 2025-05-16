package com.mini_projects.user_service.domain.user.service;

import com.mini_projects.user_service.domain.user.config.AppConfig;
import com.mini_projects.user_service.domain.user.dto.UserDTO;
import com.mini_projects.user_service.domain.user.mapper.UserMapper;
import com.mini_projects.user_service.domain.user.model.Role;
import com.mini_projects.user_service.domain.user.model.User;
import com.mini_projects.user_service.domain.user.repository.RoleRepository;
import com.mini_projects.user_service.domain.user.repository.UserRepository;
import com.mini_projects.user_service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AppConfig appConfig;
    private final RoleRepository roleRepository;

    @Value("${app.welcome.message:Welcome to the Default Environment!}")
    private String welcomeMessage;

    public UserService(UserRepository userRepository, UserMapper userMapper, AppConfig appConfig, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.appConfig = appConfig;
        this.roleRepository = roleRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getRoleId() == null) {
            throw new IllegalArgumentException("Role ID cannot be null");
        }
        Role role = roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(() -> new UserNotFoundException("Role not found with id: " + userDTO.getRoleId()));
        User user = userMapper.toEntity(userDTO);
        user.setRole(role);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        return userMapper.toDto(user);
    }

    public String getWelcomeMessage() {
        return "From @Value: " + welcomeMessage + ", From @ConfigurationProperties: " + appConfig.getWelcomeMessage();
    }
}
