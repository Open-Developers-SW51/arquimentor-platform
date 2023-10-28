package com.arquimentor.platform.arquimentor.domain.model.commands;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;

public record CreateStudentCommand(String firstname, String lastname, String email, String password) {
}
