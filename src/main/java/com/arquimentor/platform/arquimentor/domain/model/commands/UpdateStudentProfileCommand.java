package com.arquimentor.platform.arquimentor.domain.model.commands;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;

public record UpdateStudentProfileCommand(

        Long id,
        PhoneNumber phonenumber,
        String description,
        UserProfilePhoto userprofilephoto
) {
}
