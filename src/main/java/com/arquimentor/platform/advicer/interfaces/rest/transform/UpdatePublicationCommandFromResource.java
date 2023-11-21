package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.commands.UpdatePublicationCommand;
import com.arquimentor.platform.advicer.interfaces.rest.resources.UpdatePublicationResource;

public class UpdatePublicationCommandFromResource {
    public static UpdatePublicationCommand toCommandFromResource(Long publicationId, UpdatePublicationResource resource){
        return new UpdatePublicationCommand(publicationId, resource.title(), resource.description(),resource.images() );
    }
}
