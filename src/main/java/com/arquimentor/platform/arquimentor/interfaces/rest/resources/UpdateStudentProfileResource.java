package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;

public record UpdateStudentProfileResource(
        String nick,
        String phonenumber,
        String slogan,
       String userprofilephoto
) {
}
