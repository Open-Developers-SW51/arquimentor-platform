package com.arquimentor.platform.advise.domain.services.queries;


import com.arquimentor.platform.advise.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.advise.domain.model.queries.GetStudentProfileByStudentIdQuery;

import java.util.List;
import java.util.Optional;

public interface StudentProfileQueryService {
    Optional<StudentProfile> findStudentProfileByStudentId(GetStudentProfileByStudentIdQuery query);
    List<StudentProfile> findAllStudentProfiles();
}
