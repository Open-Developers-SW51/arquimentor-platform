package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.commands.CreatePublicationCommand;
import com.arquimentor.platform.advicer.interfaces.rest.resources.CreatePublicationResource;

public class CreatePublicationCommandFromResource {
    public static CreatePublicationCommand resourceToCommand(CreatePublicationResource resource){
        return new CreatePublicationCommand(resource.title(),resource.description(), resource.image(),resource.mentorProfileId());
    }
}
