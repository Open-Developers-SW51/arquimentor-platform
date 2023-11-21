package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.commands.RequestAppointmentCommand;
import com.arquimentor.platform.advicer.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResource {
    public static RequestAppointmentCommand resourceToCommand(CreateAppointmentResource resource){
        return new RequestAppointmentCommand(resource.description(),resource.studentId(),resource.mentorId());
    }
}
