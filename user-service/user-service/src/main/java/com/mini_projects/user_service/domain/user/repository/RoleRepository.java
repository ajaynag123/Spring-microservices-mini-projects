package com.mini_projects.user_service.domain.user.repository;

import com.mini_projects.user_service.domain.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<  Role, Long> {
}
