package com.arquimentor.platform.security.domain.services;

import com.arquimentor.platform.security.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
