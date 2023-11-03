package com.arquimentor.platform.arquimentor.domain.model.commands;

public record CreateStudentProfileCommand(
        String phonenumber,
        String description,
        String userprofilephoto,
        Long studentId
)
{
}
