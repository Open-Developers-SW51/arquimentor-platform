package com.arquimentor.platform.advise.domain.services.queries;

import com.arquimentor.platform.advise.domain.model.aggregates.Publication;
import com.arquimentor.platform.advise.domain.model.queries.GetPublicationByIdQuery;
import com.arquimentor.platform.advise.domain.model.queries.GetPublicationByMentorIdQuery;

import java.util.List;
import java.util.Optional;

public interface PublicationQueryService {
    List<Publication> findAllPublications();

    Optional<Publication> findPublicationById(GetPublicationByIdQuery query);

    List<Publication> findPublicationByMentorId(GetPublicationByMentorIdQuery query);
}
