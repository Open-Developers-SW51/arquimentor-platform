package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;

import java.util.List;

public record PublicationResource(
        Long id,
        String title,
        String description,
        List<String> image,
        String telephone,
        Integer views,

        Integer likes,

        Student student
) {
}
