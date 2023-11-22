package com.arquimentor.platform.advise.interfaces.rest.resources;

public record CreateStudentResource(
        String firstName,
        String lastname,
        String email,
        String password
) {

}
