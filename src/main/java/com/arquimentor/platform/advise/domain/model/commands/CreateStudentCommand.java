package com.arquimentor.platform.advise.domain.model.commands;


public record CreateStudentCommand(String firstname, String lastname, String email, String password) {
}
