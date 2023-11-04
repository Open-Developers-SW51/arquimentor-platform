package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;

public record StudentProfileResource(
        Long id,
        PhoneNumber phonenumber,
        String description,
        UserProfilePhoto userprofilephoto,


        Student student
) {
}
