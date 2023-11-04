package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateMentorCommand;

import java.util.Optional;

public interface MentorCommandService{
    Long handle(CreateMentorCommand command);

    Optional<Mentor> handle(Long idMentor);
}
