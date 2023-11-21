package com.arquimentor.platform.advicer.interfaces.rest.resources;

import com.arquimentor.platform.advicer.domain.model.aggregates.Student;

public record StudentProfileResource(

        Long id,
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        Student student
) {
}
