package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreatePublicationResource;

public class CreatePublicationCommandFromResource {
    public static CreatePublicationCommand resourceToCommand(CreatePublicationResource resource){
        return new CreatePublicationCommand(resource.title(),resource.description(), resource.image(),resource.idMentor());
    }
}
