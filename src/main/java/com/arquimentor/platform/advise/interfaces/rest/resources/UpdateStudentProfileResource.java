package com.arquimentor.platform.advise.interfaces.rest.resources;

public record UpdateStudentProfileResource(
        String nick,
        String phoneNumber,
        String slogan,
       String userProfilePhoto
) {
}
