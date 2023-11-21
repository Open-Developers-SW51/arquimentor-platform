package com.arquimentor.platform.advicer.domain.services;


import com.arquimentor.platform.advicer.domain.model.aggregates.MentorProfile;

import com.arquimentor.platform.advicer.domain.model.queries.GetMentorProfileByMentorIdQuery;


import java.util.Optional;

public interface MentorProfileQueryService {


    Optional<MentorProfile> handle(GetMentorProfileByMentorIdQuery query);
}
