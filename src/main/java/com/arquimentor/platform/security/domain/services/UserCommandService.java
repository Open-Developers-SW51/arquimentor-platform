package com.arquimentor.platform.security.domain.services;

import com.arquimentor.platform.security.domain.model.aggregates.User;
import com.arquimentor.platform.security.domain.model.commands.SignInCommand;
import com.arquimentor.platform.security.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
