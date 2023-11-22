package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.commands.UpdateStudentProfileCommand;
import com.arquimentor.platform.advise.interfaces.rest.resources.UpdateStudentProfileResource;

public class UpdateStudentProfileCommandFromResource {
    public static UpdateStudentProfileCommand toCommandFromResource(Long studentProfileId, UpdateStudentProfileResource resource) {

        return new UpdateStudentProfileCommand(
                studentProfileId,
                resource.nick(),
                resource.phoneNumber(),
                resource.slogan(),
                resource.userProfilePhoto()
        );
    }
}
