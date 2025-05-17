package com.mini_projects.user_service.domain.user.repository;

import com.mini_projects.user_service.domain.user.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
