package com.arquimentor.platform.arquimentor.domain.services;


import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentProfileByStudentIdQuery;

import java.util.Optional;

public interface StudentProfileQueryService {

    //  Optional<StudentProfile> handle(GetStudentProfileByPhoneNumberQuery query);
    Optional<StudentProfile> handle(GetStudentProfileByStudentIdQuery query);
}
