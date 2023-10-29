package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.PublicationResource;

public class PublicationEntityToResource {
    public static PublicationResource toResourceFromEntity(Publication entity){
        return new PublicationResource(entity.getId(),entity.getTitle(),entity.getDescription(),entity.getImages(), entity.getTelephone(),entity.getViews(),entity.getStudent());
    }
}
