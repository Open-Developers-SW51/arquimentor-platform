package com.arquimentor.platform.advise.interfaces.rest.resources;

import com.arquimentor.platform.advise.domain.model.aggregates.Student;

public record StudentProfileResource(

        Long id,
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        Student student
) {
}
