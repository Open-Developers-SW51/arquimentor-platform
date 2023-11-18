package com.arquimentor.platform.security.domain.services;

import com.arquimentor.platform.security.domain.model.entities.Role;
import com.arquimentor.platform.security.domain.model.queries.GetAllRolesQuery;
import com.arquimentor.platform.security.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
