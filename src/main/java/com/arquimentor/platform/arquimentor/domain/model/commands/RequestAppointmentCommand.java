package com.arquimentor.platform.arquimentor.domain.model.commands;

public record RequestAppointmentCommand(String description, Long studentId, Long Id) {
}
