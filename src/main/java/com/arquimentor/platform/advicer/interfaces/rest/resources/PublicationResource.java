package com.arquimentor.platform.advicer.interfaces.rest.resources;

import com.arquimentor.platform.advicer.domain.model.aggregates.MentorProfile;

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
