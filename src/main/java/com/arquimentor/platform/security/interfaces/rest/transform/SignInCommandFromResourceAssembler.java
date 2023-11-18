package com.arquimentor.platform.security.interfaces.rest.transform;

import com.arquimentor.platform.security.domain.model.commands.SignInCommand;
import com.arquimentor.platform.security.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
