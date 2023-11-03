package com.arquimentor.platform.arquimentor.domain.services;


import com.arquimentor.platform.arquimentor.domain.model.aggregates.MentorProfile;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateMentorProfileCommand;

import com.arquimentor.platform.arquimentor.domain.model.commands.UpdateMentorProfileCommand;


import java.util.List;
import java.util.Optional;

public interface MentorProfileCommandService {
    Long handle(CreateMentorProfileCommand command);
    Optional<MentorProfile> handle(Long idMentorProfile);
    List<MentorProfile> findAll();
    List<MentorProfile> findMentorProfileByIdStudent(Long idMentorProfile);

    Optional<MentorProfile> updateMentorProfileByID(UpdateMentorProfileCommand command);



}
