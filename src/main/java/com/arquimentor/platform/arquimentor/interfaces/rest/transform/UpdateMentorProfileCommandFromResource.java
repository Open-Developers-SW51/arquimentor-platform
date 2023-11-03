package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.UpdateMentorProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.UpdateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.UpdateMentorProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.UpdateStudentProfileResource;

public class UpdateMentorProfileCommandFromResource {
    public static UpdateMentorProfileCommand toCommandFromResource(Long mentorProfileId, UpdateMentorProfileResource resource) {

        return new UpdateMentorProfileCommand(
                mentorProfileId,
                resource.phonenumber(),
                resource.description(),
                resource.userprofilephoto(),
                resource.certificates()
        );
    }
}
