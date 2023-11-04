package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;

public record AppointmentResource(
        Long appointmentId,

        String description,

        String status,

        Mentor mentor,
        Student student
) {
}
