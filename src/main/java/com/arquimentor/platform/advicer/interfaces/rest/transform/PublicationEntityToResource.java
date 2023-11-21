package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.aggregates.Publication;
import com.arquimentor.platform.advicer.interfaces.rest.resources.PublicationResource;

public class PublicationEntityToResource {
    public static PublicationResource toResourceFromEntity(Publication entity){
        return new PublicationResource(entity.getId(),entity.getTitle(),entity.getDescription(),entity.getImages(),entity.getViews(),entity.getLikes(),entity.getMentorProfile());
    }
}
