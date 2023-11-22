package com.arquimentor.platform.advise.interfaces.rest.resources;

public record StudentResource(
        Long id,
        String fullName,
        String email,
        String password
) {

}
