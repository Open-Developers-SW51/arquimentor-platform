package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import java.util.List;

public record CreatePublicationResource (
        String title,
        String description,
        String image,
        String telephone,

        Long idStudent
){
}
