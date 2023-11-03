package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.commands.CancelAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.ConfirmAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.RejectAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.RequestAppointmentCommand;

public interface AppointmentCommandService {
    Long handle(RequestAppointmentCommand command);
    Long handle(RejectAppointmentCommand command);
    Long handle(ConfirmAppointmentCommand command);
    Long handle(CancelAppointmentCommand command);

}
