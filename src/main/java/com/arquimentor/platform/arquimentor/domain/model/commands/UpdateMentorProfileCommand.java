package com.arquimentor.platform.arquimentor.domain.model.commands;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;

import java.util.List;

public record UpdateMentorProfileCommand(

        Long id,
        PhoneNumber phonenumber,
        String description,
        UserProfilePhoto userprofilephoto,
        List<String> certificates
) {
}
