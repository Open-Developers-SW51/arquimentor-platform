package com.arquimentor.platform.advicer.interfaces.rest.resources;

public record UpdateStudentProfileResource(
        String nick,
        String phoneNumber,
        String slogan,
       String userProfilePhoto
) {
}
