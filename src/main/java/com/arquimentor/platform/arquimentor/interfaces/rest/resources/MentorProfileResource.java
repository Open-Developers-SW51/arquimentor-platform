package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;

import java.util.List;

public record MentorProfileResource(
        Long id,
        String phonenumber,
        String description,
        String userprofilephoto,
        List<String> certificates,

        Mentor mentor
) {
}
