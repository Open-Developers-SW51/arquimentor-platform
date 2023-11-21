package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.aggregates.Appointment;
import com.arquimentor.platform.advicer.interfaces.rest.resources.AppointmentResource;

public class AppointmentEntityToResource {
    public static AppointmentResource toResourceFromEntity(Appointment appointment){
        return new AppointmentResource(appointment.getId(),appointment.getDescription(),appointment.getStatus(),appointment.getMentor(),appointment.getStudent());
    }
}
