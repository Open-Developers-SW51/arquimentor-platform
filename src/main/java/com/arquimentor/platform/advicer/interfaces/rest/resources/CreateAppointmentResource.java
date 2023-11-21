package com.arquimentor.platform.advicer.interfaces.rest.resources;

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
