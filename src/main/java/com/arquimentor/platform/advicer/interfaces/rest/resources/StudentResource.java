package com.arquimentor.platform.advicer.interfaces.rest.resources;

public record StudentResource(
        Long id,
        String fullName,
        String email,
        String password
) {

}
