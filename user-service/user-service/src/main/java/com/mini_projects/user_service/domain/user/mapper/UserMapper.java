package com.mini_projects.user_service.domain.user.mapper;

import com.mini_projects.user_service.domain.user.dto.UserDTO;
import com.mini_projects.user_service.domain.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "role", target = "role")
    UserDTO toDto(User user);


    @Mapping(source = "roleId", target = "role.id")
    @Mapping(target = "role", ignore = true)
    User toEntity(UserDTO userDTO);
}
