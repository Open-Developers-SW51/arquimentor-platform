package com.arquimentor.platform.advicer.application.internal.queryservices;

import com.arquimentor.platform.advicer.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.advicer.domain.model.queries.GetMentorProfileByMentorIdQuery;
import com.arquimentor.platform.advicer.domain.services.MentorProfileQueryService;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
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
    public Optional<MentorProfile> handle(GetMentorProfileByMentorIdQuery query) {

        List<MentorProfile> profiles = mentorProfileRepository.findByMentorId(query.MentorId());
        return profiles.isEmpty() ? Optional.empty() : Optional.of(profiles.get(0));
    }
    public List<MentorProfile> findAll(){
        return mentorProfileRepository.findAll();
    }

 }
