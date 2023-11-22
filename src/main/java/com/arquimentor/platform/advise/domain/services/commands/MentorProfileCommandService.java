package com.arquimentor.platform.advise.domain.services.commands;


import com.arquimentor.platform.advise.domain.model.aggregates.MentorProfile;

import com.arquimentor.platform.advise.domain.model.commands.CreateMentorProfileCommand;

import com.arquimentor.platform.advise.domain.model.commands.UpdateMentorProfileCommand;


import java.util.List;
import java.util.Optional;

public interface MentorProfileCommandService {
    Long createMentorProfile(CreateMentorProfileCommand command);
    Optional<MentorProfile> updateMentorProfileByID(UpdateMentorProfileCommand command);
}
