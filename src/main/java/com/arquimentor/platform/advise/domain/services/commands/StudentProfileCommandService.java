package com.arquimentor.platform.advise.domain.services.commands;


import com.arquimentor.platform.advise.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.advise.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.advise.domain.model.commands.DeletePublicationCommand;
import com.arquimentor.platform.advise.domain.model.commands.UpdateStudentProfileCommand;

import java.util.List;
import java.util.Optional;

public interface StudentProfileCommandService {
    Long createStudentProfile(CreateStudentProfileCommand command);

    Optional<StudentProfile> updateStudentProfileByID(UpdateStudentProfileCommand command);


    void deletePublication(DeletePublicationCommand deletePublicationCommand);
}
