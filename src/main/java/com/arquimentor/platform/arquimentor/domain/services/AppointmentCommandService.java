package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Appointment;
import com.arquimentor.platform.arquimentor.domain.model.commands.CancelAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.ConfirmAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.RejectAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.RequestAppointmentCommand;

import java.util.List;
import java.util.Optional;

public interface AppointmentCommandService {
    Long handle(RequestAppointmentCommand command);
    Long handle(RejectAppointmentCommand command);
    Long handle(ConfirmAppointmentCommand command);
    Long handle(CancelAppointmentCommand command);

    Optional<Appointment> handle(Long appointmentId);
    List<Appointment> findAll();

    List<Appointment> findAppointmentsByStudentId(Long studentId);

    List<Appointment> findAppointmentsByMentorId(Long mentorId);

}
