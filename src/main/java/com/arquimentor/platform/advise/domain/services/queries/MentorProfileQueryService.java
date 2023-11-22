package com.arquimentor.platform.advise.domain.services.queries;


import com.arquimentor.platform.advise.domain.model.aggregates.MentorProfile;

import com.arquimentor.platform.advise.domain.model.queries.GetMentorProfileByIdQuery;
import com.arquimentor.platform.advise.domain.model.queries.GetMentorProfileByMentorIdQuery;


import java.util.List;
import java.util.Optional;

public interface MentorProfileQueryService {


    Optional<MentorProfile> findMentorProfileByMentorId(GetMentorProfileByMentorIdQuery query);
    Optional<MentorProfile> findMentorProfileById(GetMentorProfileByIdQuery query);

    List<MentorProfile> findAllMentorProfiles();
}
