package com.arquimentor.platform.security.domain.model.commands;

import com.arquimentor.platform.security.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
