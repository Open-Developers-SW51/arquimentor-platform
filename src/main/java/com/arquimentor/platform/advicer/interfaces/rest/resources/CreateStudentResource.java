package com.arquimentor.platform.advicer.interfaces.rest.resources;

public record CreateStudentResource(
        String firstName,
        String lastname,
        String email,
        String password
) {

}
