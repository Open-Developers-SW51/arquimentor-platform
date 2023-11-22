package com.arquimentor.platform.advise.interfaces.rest.resources;

import com.arquimentor.platform.advise.domain.model.aggregates.MentorProfile;

import java.util.List;

public record PublicationResource(
        Long id,
        String title,
        String description,
        List<String> image,
        Integer views,

        Integer likes,

        MentorProfile mentorProfile
) {
}
