package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.aggregates.Publication;
import com.arquimentor.platform.advise.interfaces.rest.resources.PublicationResource;

public class PublicationEntityToResource {
    public static PublicationResource toResourceFromEntity(Publication entity){
        return new PublicationResource(entity.getId(),entity.getTitle(),entity.getDescription(),entity.getImages(),entity.getViews(),entity.getLikes(),entity.getMentorProfile());
    }
}
