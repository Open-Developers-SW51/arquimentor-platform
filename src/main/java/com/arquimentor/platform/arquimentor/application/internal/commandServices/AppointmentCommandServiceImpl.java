package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.model.commands.CancelAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.ConfirmAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.RejectAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.RequestAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.services.AppointmentCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.AppointmentRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentRepository;

public class AppointmentCommandServiceImpl implements AppointmentCommandService {

    private final MentorRepository mentorRepository;
    private final StudentRepository studentRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentCommandServiceImpl(MentorRepository mentorRepository, StudentRepository studentRepository, AppointmentRepository appointmentRepository) {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Long handle(RequestAppointmentCommand command) {
        return null;
    }

    @Override
    public Long handle(RejectAppointmentCommand command) {
        return null;
    }

    @Override
    public Long handle(ConfirmAppointmentCommand command) {
        return null;
    }

    @Override
    public Long handle(CancelAppointmentCommand command) {
        return null;
    }
}
