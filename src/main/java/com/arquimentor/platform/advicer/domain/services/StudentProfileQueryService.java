package com.arquimentor.platform.advicer.domain.services;


import com.arquimentor.platform.advicer.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.advicer.domain.model.queries.GetStudentProfileByStudentIdQuery;

import java.util.Optional;

public interface StudentProfileQueryService {

    //  Optional<StudentProfile> handle(GetStudentProfileByPhoneNumberQuery query);
    Optional<StudentProfile> handle(GetStudentProfileByStudentIdQuery query);
}
