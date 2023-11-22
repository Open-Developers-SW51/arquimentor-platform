package com.arquimentor.platform.advise.domain.services.queries;

import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advise.domain.model.queries.GetMentorByIdQuery;

import java.util.Optional;

public interface MentorQueryService {
    Optional<Mentor> findMentorById(GetMentorByIdQuery query);
}
