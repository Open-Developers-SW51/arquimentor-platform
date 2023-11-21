package com.arquimentor.platform.advicer.interfaces.rest.resources;

import com.arquimentor.platform.advicer.domain.model.aggregates.Mentor;

import java.util.List;

public record MentorProfileResource(
        Long id,
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        List<String> certificates,

        Mentor mentor
) {
}
