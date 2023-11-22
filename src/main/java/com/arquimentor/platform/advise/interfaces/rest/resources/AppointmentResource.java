package com.arquimentor.platform.advise.interfaces.rest.resources;

import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advise.domain.model.aggregates.Student;

public record AppointmentResource(
        Long appointmentId,

        String description,

        String status,

        Mentor mentor,
        Student student
) {
}
