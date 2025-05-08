package com.mini_projects.user_service.mapper;

import com.mini_projects.user_service.dto.UserDTO;
import com.mini_projects.user_service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        if(user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return  userDTO;
    }

    public User toEntity(UserDTO userDTO){
        if (userDTO == null){
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
