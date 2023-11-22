package com.arquimentor.platform.security.interfaces.rest.transform;

import com.arquimentor.platform.security.domain.model.entities.Role;
import com.arquimentor.platform.security.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
