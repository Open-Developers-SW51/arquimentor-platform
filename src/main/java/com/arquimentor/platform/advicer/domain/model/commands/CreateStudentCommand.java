package com.arquimentor.platform.advicer.domain.model.commands;


public record CreateStudentCommand(String firstname, String lastname, String email, String password) {
}
