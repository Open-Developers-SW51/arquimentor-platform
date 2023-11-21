package com.arquimentor.platform.advicer.domain.model.commands;

public record UpdateStudentProfileCommand(
        Long id,
        String nick,
        String phonenumber,
        String slogan,
        String userprofilephoto
) {
}
