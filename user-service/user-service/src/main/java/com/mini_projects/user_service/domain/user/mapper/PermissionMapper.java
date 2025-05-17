package com.mini_projects.user_service.domain.user.mapper;

import com.mini_projects.user_service.domain.user.dto.PermissionDTO;
import com.mini_projects.user_service.domain.user.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDTO toDTO(Permission permission);

    Permission toEntity(PermissionDTO permissionDTO);
}
