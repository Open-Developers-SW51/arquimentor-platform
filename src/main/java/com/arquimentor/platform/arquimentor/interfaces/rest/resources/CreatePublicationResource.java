package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import java.util.List;

public record CreatePublicationResource (
        String title,
        String description,
        List<String> image,
        Long mentorProfileId
){
}
