package com.arquimentor.platform.arquimentor.domain.model.commands;

public record CreateStudentProfileCommand(
        String nick,
        String phonenumber,
        String slogan,
        String userprofilephoto,
        Long studentId
)
{
}
