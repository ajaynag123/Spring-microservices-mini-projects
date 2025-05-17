package com.mini_projects.user_service.domain.user.dto;

import com.mini_projects.user_service.domain.user.model.Permission;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
    private Long id;
    private String name;

    @Builder.Default
    private Set<Permission> permissions = new HashSet<>();
}
