package com.arquimentor.platform.security.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.security.domain.model.entities.Role;
import com.arquimentor.platform.security.domain.model.valueobjects.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);

    boolean existsByName(Roles name);
}
