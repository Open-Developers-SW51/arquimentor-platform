package com.arquimentor.platform.security.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}
