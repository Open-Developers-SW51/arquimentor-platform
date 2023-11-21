package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.commands.UpdateMentorProfileCommand;
import com.arquimentor.platform.advicer.interfaces.rest.resources.UpdateMentorProfileResource;

public class UpdateMentorProfileCommandFromResource {
    public static UpdateMentorProfileCommand toCommandFromResource(Long mentorProfileId, UpdateMentorProfileResource resource) {

        return new UpdateMentorProfileCommand(
                mentorProfileId,
                resource.nick(),
                resource.phoneNumber(),
                resource.slogan(),
                resource.userProfilePhoto(),
                resource.certificates()
        );
    }
}
