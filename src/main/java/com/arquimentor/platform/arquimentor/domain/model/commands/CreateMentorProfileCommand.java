package com.arquimentor.platform.arquimentor.domain.model.commands;

public record CreateMentorProfileCommand(
        String phonenumber,
        String description,
        String userprofilephoto,
        String certificates,
        Long mentorId
)
{
}
