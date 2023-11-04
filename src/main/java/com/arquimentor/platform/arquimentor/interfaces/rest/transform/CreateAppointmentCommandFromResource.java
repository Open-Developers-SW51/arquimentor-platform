package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.RequestAppointmentCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResource {
    public static RequestAppointmentCommand resourceToCommand(CreateAppointmentResource resource){
        return new RequestAppointmentCommand(resource.description(),resource.studentId(),resource.mentorId());
    }
}
