package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;

import java.util.List;

public record CreateMentorProfileResource(
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        List<String> certificates,
        Long idMentor
) {
}
