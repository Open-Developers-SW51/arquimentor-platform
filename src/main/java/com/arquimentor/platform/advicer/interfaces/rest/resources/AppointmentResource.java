package com.arquimentor.platform.advicer.interfaces.rest.resources;

import com.arquimentor.platform.advicer.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advicer.domain.model.aggregates.Student;

public record AppointmentResource(
        Long appointmentId,

        String description,

        String status,

        Mentor mentor,
        Student student
) {
}
