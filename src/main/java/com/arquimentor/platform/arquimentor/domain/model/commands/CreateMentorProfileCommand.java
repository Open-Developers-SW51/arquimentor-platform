package com.arquimentor.platform.arquimentor.domain.model.commands;

import java.util.List;

public record CreateMentorProfileCommand(
        String phonenumber,
        String description,
        String userprofilephoto,
        List<String> certificates,
        Long mentorId
)
{
}
