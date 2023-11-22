package com.arquimentor.platform.advise.application.internal.queryservices;

import com.arquimentor.platform.advise.domain.model.aggregates.Publication;
import com.arquimentor.platform.advise.domain.model.queries.GetPublicationByIdQuery;
import com.arquimentor.platform.advise.domain.model.queries.GetPublicationByMentorIdQuery;
import com.arquimentor.platform.advise.domain.services.queries.PublicationQueryService;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationQueryServiceImpl implements PublicationQueryService {

    private final PublicationRepository publicationRepository;

    public PublicationQueryServiceImpl(PublicationRepository publicationRepository, MentorProfileRepository mentorProfileRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public List<Publication> findAllPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public Optional<Publication> findPublicationById(GetPublicationByIdQuery query) {
        return publicationRepository.findById(query.idPublication());
    }

    @Override
    public List<Publication> findPublicationByMentorId(GetPublicationByMentorIdQuery query) {
        return publicationRepository.findByMentorProfileId(query.idMentor());
    }
}
