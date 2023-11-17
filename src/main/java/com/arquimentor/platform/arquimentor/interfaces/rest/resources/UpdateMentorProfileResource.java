package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;

import java.util.List;

public record UpdateMentorProfileResource(
        String nick,
        String phonenumber,
        String slogan,
        String userprofilephoto,
        List<String> certificates

) {
}
