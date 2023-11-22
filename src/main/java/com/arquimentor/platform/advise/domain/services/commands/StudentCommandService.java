package com.arquimentor.platform.advise.domain.services.commands;

import com.arquimentor.platform.advise.domain.model.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long createStudent(CreateStudentCommand command);
}
