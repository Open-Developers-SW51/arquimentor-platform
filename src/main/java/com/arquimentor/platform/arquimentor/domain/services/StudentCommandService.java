package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.commands.StudentCommand;

public interface StudentCommandService {
    Long handle(StudentCommand command);
}
