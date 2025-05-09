package com.mini_projects.user_service.domain.user.mapper;

import com.mini_projects.user_service.domain.user.dto.UserDTO;
import com.mini_projects.user_service.domain.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "id", source = "id")
    UserDTO toDto(User user);

    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "id", ignore = true)
    User toEntity(UserDTO userDTO);
}
