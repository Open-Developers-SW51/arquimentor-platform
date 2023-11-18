package com.arquimentor.platform.security.interfaces.rest.transform;

import com.arquimentor.platform.security.domain.model.aggregates.User;
import com.arquimentor.platform.security.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(role -> role.getName().name()).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
