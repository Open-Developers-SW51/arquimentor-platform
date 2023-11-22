package com.arquimentor.platform.advise.domain.services.commands;

import com.arquimentor.platform.advise.domain.model.aggregates.Appointment;
import com.arquimentor.platform.advise.domain.model.commands.CancelAppointmentCommand;
import com.arquimentor.platform.advise.domain.model.commands.ConfirmAppointmentCommand;
import com.arquimentor.platform.advise.domain.model.commands.RejectAppointmentCommand;
import com.arquimentor.platform.advise.domain.model.commands.RequestAppointmentCommand;

import java.util.List;
import java.util.Optional;

public interface AppointmentCommandService {
    Long updateToAppointmentRequest(RequestAppointmentCommand command);
    Long updateToAppointmentReject(RejectAppointmentCommand command);
    Long updateToAppointmentConfirm(ConfirmAppointmentCommand command);
    Long updateToAppointmentCancel(CancelAppointmentCommand command);

}
