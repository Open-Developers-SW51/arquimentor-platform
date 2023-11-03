package com.arquimentor.platform.arquimentor.domain.services;


import com.arquimentor.platform.arquimentor.domain.model.aggregates.MentorProfile;

import com.arquimentor.platform.arquimentor.domain.model.queries.GetMentorProfileByMentorIdQuery;


import java.util.Optional;

public interface MentorProfileQueryService {


    Optional<MentorProfile> handle(GetMentorProfileByMentorIdQuery query);
}
