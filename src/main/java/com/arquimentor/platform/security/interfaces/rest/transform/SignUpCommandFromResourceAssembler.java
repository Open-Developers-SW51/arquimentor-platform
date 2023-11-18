package com.arquimentor.platform.security.interfaces.rest.transform;

import com.arquimentor.platform.security.domain.model.commands.SignUpCommand;
import com.arquimentor.platform.security.domain.model.entities.Role;
import com.arquimentor.platform.security.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource signUpResource) {
        var roles = signUpResource.roles() != null ? signUpResource.roles().stream()
                .map(name -> Role.toRoleFromName(name))
                .toList() : new ArrayList<Role>();
        return new SignUpCommand(signUpResource.username(), signUpResource.password(), roles);
    }
}
