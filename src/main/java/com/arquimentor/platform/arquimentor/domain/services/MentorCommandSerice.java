package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateMentorCommand;

public interface MentorCommandSerice {
    Long handle(CreateMentorCommand command);
}
