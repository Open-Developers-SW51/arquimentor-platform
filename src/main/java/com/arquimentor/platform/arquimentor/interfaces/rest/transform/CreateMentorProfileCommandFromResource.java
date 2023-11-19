package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateMentorProfileCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateMentorProfileResource;

public class CreateMentorProfileCommandFromResource {
    public static CreateMentorProfileCommand resourceToCommand(CreateMentorProfileResource resource) {
        return new CreateMentorProfileCommand(
                resource.nick(),
                resource.phoneNumber(), // Accede directamente al campo 'phonenumber'
                resource.slogan(),
                resource.userProfilePhoto(),
                resource.certificates(),
                resource.idMentor()
        );
    }
}


