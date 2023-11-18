package com.arquimentor.platform.security.domain.services;

import com.arquimentor.platform.security.domain.model.aggregates.User;
import com.arquimentor.platform.security.domain.model.queries.GetAllUsersQuery;
import com.arquimentor.platform.security.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
