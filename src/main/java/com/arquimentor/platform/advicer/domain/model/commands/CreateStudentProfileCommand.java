package com.arquimentor.platform.advicer.domain.model.commands;

public record CreateStudentProfileCommand(
        String nick,
        String phonenumber,
        String slogan,
        String userprofilephoto,
        Long studentId
)
{
}
