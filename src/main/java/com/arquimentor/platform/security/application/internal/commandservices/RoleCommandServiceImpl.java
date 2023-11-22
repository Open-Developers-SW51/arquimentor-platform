package com.arquimentor.platform.security.application.internal.commandservices;

import com.arquimentor.platform.security.domain.model.commands.SeedRolesCommand;
import com.arquimentor.platform.security.domain.model.entities.Role;
import com.arquimentor.platform.security.domain.model.valueobjects.Roles;
import com.arquimentor.platform.security.domain.services.RoleCommandService;
import com.arquimentor.platform.security.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if (!roleRepository.existsByName(role))
                roleRepository.save(new Role(Roles.valueOf(role.name())));
        });
    }
}
