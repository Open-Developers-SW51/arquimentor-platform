package com.arquimentor.platform.advicer.domain.model.commands;

public record RequestAppointmentCommand(String description, Long studentId, Long mentorId) {
}
