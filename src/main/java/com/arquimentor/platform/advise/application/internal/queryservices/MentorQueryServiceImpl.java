package com.arquimentor.platform.advise.application.internal.queryservices;

import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advise.domain.model.queries.GetMentorByIdQuery;
import com.arquimentor.platform.advise.domain.services.queries.MentorQueryService;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorQueryServiceImpl implements MentorQueryService {

    private final MentorRepository mentorRepository;

    public MentorQueryServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Optional<Mentor> findMentorById(GetMentorByIdQuery query) {
        return mentorRepository.findById(query.idMentor());
    }
}
