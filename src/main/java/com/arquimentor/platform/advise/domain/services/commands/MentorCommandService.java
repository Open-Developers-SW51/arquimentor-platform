package com.arquimentor.platform.advise.domain.services.commands;

import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advise.domain.model.commands.CreateMentorCommand;

import java.util.Optional;

public interface MentorCommandService{
    Long createMentor(CreateMentorCommand command);

}
