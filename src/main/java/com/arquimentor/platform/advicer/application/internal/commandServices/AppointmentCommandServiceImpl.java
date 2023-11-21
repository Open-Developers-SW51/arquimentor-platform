package com.arquimentor.platform.advicer.application.internal.commandServices;

import com.arquimentor.platform.advicer.domain.model.aggregates.Appointment;
import com.arquimentor.platform.advicer.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advicer.domain.model.aggregates.Student;
import com.arquimentor.platform.advicer.domain.model.commands.CancelAppointmentCommand;
import com.arquimentor.platform.advicer.domain.model.commands.ConfirmAppointmentCommand;
import com.arquimentor.platform.advicer.domain.model.commands.RejectAppointmentCommand;
import com.arquimentor.platform.advicer.domain.model.commands.RequestAppointmentCommand;
import com.arquimentor.platform.advicer.domain.services.AppointmentCommandService;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.AppointmentRepository;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        Student student = studentRepository.findById(command.studentId())
                .orElseThrow();
        Mentor mentor = mentorRepository.findById(command.mentorId())
                .orElseThrow();
        Appointment appointment = new Appointment(command.description(),student,mentor);
        appointmentRepository.save(appointment);
        return appointment.getId();
    }

    @Override
    public Long handle(RejectAppointmentCommand command) {
        appointmentRepository.findById(command.appointmentId())
                .map(appointment -> {
                    appointment.reject();
                    appointmentRepository.save(appointment);
                    return appointment.getId();
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return null;
    }

    @Override
    public Long handle(ConfirmAppointmentCommand command) {
        appointmentRepository.findById(command.appointmentId())
                .map(appointment -> {
                    appointment.confirm();
                    appointmentRepository.save(appointment);
                    return appointment.getId();
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return null;
    }

    @Override
    public Long handle(CancelAppointmentCommand command) {
        appointmentRepository.findById(command.appointmentId())
                .map(appointment -> {
                    appointment.cancel();
                    appointmentRepository.save(appointment);
                    return appointment.getId();
                }).orElseThrow(() -> new RuntimeException("Appointment not found"));
        return null;
    }

    @Override
    public Optional<Appointment> handle(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findAppointmentsByStudentId(Long studentId) {
        return appointmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Appointment> findAppointmentsByMentorId(Long mentorId) {
        return appointmentRepository.findByMentorId(mentorId);
    }
}
