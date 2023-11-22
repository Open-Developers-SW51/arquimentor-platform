package com.arquimentor.platform.advise.domain.model.commands;

public record RequestAppointmentCommand(String description, Long studentId, Long mentorId) {
}
