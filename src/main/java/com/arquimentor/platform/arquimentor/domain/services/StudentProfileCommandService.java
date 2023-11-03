package com.arquimentor.platform.arquimentor.domain.services;


import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.UpdateStudentProfileCommand;

import java.util.List;
import java.util.Optional;

public interface StudentProfileCommandService {
    Long handle(CreateStudentProfileCommand command);
    Optional<StudentProfile> handle(Long idStudentProfile);
    List<StudentProfile> findAll();
    List<StudentProfile> findStudentProfileByIdStudent(Long idStudentProfile);

    Optional<StudentProfile> updateStudentProfileByID(UpdateStudentProfileCommand command);



}
