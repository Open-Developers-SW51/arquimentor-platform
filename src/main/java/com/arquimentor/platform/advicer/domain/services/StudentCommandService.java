package com.arquimentor.platform.advicer.domain.services;

import com.arquimentor.platform.advicer.domain.model.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);
}
