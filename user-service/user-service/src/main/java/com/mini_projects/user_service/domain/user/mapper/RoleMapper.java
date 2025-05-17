package com.mini_projects.user_service.domain.user.mapper;

import com.mini_projects.user_service.domain.user.dto.RoleDTO;
import com.mini_projects.user_service.domain.user.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PermissionMapper.class)
public interface RoleMapper {

    RoleDTO toDTO(Role role);

    @Mapping(target = "permissions", ignore = true)
    Role toEntity(RoleDTO roleDTO);
}
