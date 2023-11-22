package com.arquimentor.platform.advise.domain.services.queries;

import com.arquimentor.platform.advise.domain.model.aggregates.Appointment;
import com.arquimentor.platform.advise.domain.model.queries.GetAppointmentByIdQuery;
import com.arquimentor.platform.advise.domain.model.queries.GetAppointmentByStudentId;
import com.arquimentor.platform.advise.domain.model.queries.GetAppointmentsByMentorId;
import com.arquimentor.platform.advise.domain.model.queries.GetMentorProfileByMentorIdQuery;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {
    Optional<Appointment> findAppointmentById(GetAppointmentByIdQuery query);

    List<Appointment> findAll();

    List<Appointment> findAppointmentsByStudentId(GetAppointmentByStudentId query);

    List<Appointment> findAppointmentsByMentorId(GetAppointmentsByMentorId query);
}
