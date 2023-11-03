package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.UpdatePublicationCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.UpdatePublicationResource;

public class UpdatePublicationCommandFromResource {
    public static UpdatePublicationCommand toCommandFromResource(Long publicationId, UpdatePublicationResource resource){
        return new UpdatePublicationCommand(publicationId, resource.title(), resource.description(),resource.images() );
    }
}
