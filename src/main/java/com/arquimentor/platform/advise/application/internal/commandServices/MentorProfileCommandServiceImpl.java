package com.arquimentor.platform.advise.application.internal.commandServices;


import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advise.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.advise.domain.model.commands.CreateMentorProfileCommand;
import com.arquimentor.platform.advise.domain.model.commands.UpdateMentorProfileCommand;
import com.arquimentor.platform.advise.domain.services.commands.MentorProfileCommandService;

import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.MentorRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorProfileCommandServiceImpl implements MentorProfileCommandService {
    private final MentorProfileRepository mentorProfileRepository;
    private final MentorRepository mentorRepository;

    public MentorProfileCommandServiceImpl(MentorProfileRepository mentorProfileRepository, MentorRepository mentorRepository) {
        this.mentorProfileRepository = mentorProfileRepository;
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Long createMentorProfile(CreateMentorProfileCommand command) {
        Optional<Mentor> mentor = mentorRepository.findById(command.mentorId());

        if (mentor.isPresent()) {
            MentorProfile mentorProfile = new MentorProfile(
                    command.nick(),
                    command.phonenumber(),
                    command.slogan(),
                    command.userprofilephoto(),
                    command.certificates(),
                    mentor.get()
            );

            MentorProfile savedProfile = mentorProfileRepository.save(mentorProfile);
            return savedProfile.getId();
        } else {
            return null;
        }
    }
    @Override
    public Optional<MentorProfile> updateMentorProfileByID(UpdateMentorProfileCommand command) {
        Optional<MentorProfile> existingProfile = mentorProfileRepository.findById(command.id());

        if (existingProfile.isPresent()) {
            var mentorProfileToUpdate = mentorProfileRepository.findById(command.id()).get();
            MentorProfile savedProfile = mentorProfileRepository.save(mentorProfileToUpdate.updateMentorProfile(
                    command.nick(),
                    command.phoneNumber(),
                    command.slogan(),
                    command.userProfilePhoto(),
                    command.certificates()
            ));
            return Optional.of(savedProfile);
        } else {
            // Maneja el caso en el que no se encuentra el perfil a actualizar
            return Optional.empty();
        }
    }
}