package com.arquimentor.platform.advicer.domain.services;

import com.arquimentor.platform.advicer.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advicer.domain.model.commands.CreateMentorCommand;

import java.util.Optional;

public interface MentorCommandService{
    Long handle(CreateMentorCommand command);

    Optional<Mentor> handle(Long idMentor);
}
