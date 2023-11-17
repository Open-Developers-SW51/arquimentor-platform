package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.UpdateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.UpdateStudentProfileResource;

public class UpdateStudentProfileCommandFromResource {
    public static UpdateStudentProfileCommand toCommandFromResource(Long studentProfileId, UpdateStudentProfileResource resource) {

        return new UpdateStudentProfileCommand(
                resource.nick(),
                studentProfileId,
                resource.phonenumber(),
                resource.slogan(),
                resource.userprofilephoto()
        );
    }
}
