package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record CreateAppointmentResource(
        @NotNull
        String description,
        @NotNull
        Long studentId,
        @NotNull
        Long mentorId
) {
}
