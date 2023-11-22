package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.commands.UpdatePublicationCommand;
import com.arquimentor.platform.advise.interfaces.rest.resources.UpdatePublicationResource;

public class UpdatePublicationCommandFromResource {
    public static UpdatePublicationCommand toCommandFromResource(Long publicationId, UpdatePublicationResource resource){
        return new UpdatePublicationCommand(publicationId, resource.title(), resource.description(),resource.images() );
    }
}
