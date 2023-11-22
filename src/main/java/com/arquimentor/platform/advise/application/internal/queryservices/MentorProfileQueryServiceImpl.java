package com.arquimentor.platform.advise.application.internal.queryservices;

import com.arquimentor.platform.advise.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.advise.domain.model.queries.GetMentorProfileByIdQuery;
import com.arquimentor.platform.advise.domain.model.queries.GetMentorProfileByMentorIdQuery;
import com.arquimentor.platform.advise.domain.services.queries.MentorProfileQueryService;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MentorProfileQueryServiceImpl implements MentorProfileQueryService {

    private final MentorProfileRepository mentorProfileRepository;

    public MentorProfileQueryServiceImpl(MentorProfileRepository mentorProfileRepository) {
        this.mentorProfileRepository = mentorProfileRepository;
    }

    @Override
    public Optional<MentorProfile> findMentorProfileByMentorId(GetMentorProfileByMentorIdQuery query) {

        List<MentorProfile> profiles = mentorProfileRepository.findByMentorId(query.mentorId());
        return profiles.isEmpty() ? Optional.empty() : Optional.of(profiles.get(0));
    }

    @Override
    public Optional<MentorProfile> findMentorProfileById(GetMentorProfileByIdQuery query) {
        return  mentorProfileRepository.findById(query.mentorProfileId());
    }

    @Override
    public List<MentorProfile> findAllMentorProfiles() {
        return mentorProfileRepository.findAll();
    }

 }
