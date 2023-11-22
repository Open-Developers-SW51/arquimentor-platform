package com.arquimentor.platform.advise.interfaces.rest.resources;

public record CreateStudentProfileResource(
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        Long idStudent
) {
}
