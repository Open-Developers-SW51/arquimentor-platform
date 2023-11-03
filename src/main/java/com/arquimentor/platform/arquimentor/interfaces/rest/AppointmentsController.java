package com.arquimentor.platform.arquimentor.interfaces.rest;

import com.arquimentor.platform.arquimentor.domain.model.commands.CancelAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.ConfirmAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.RejectAppointmentCommand;
import com.arquimentor.platform.arquimentor.domain.services.AppointmentCommandService;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.AppointmentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateAppointmentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.PublicationResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.AppointmentEntityToResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.CreateAppointmentCommandFromResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.PublicationEntityToResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/appointments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Appointments", description = "Appointments Management Endpoints")
public class AppointmentsController {
    private final AppointmentCommandService appointmentCommandService;

    public AppointmentsController(AppointmentCommandService appointmentCommandService) {
        this.appointmentCommandService = appointmentCommandService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResource>> getAllAppointments() {
        var listAppointments = appointmentCommandService.findAll();
        List<AppointmentResource> appointmentResources = listAppointments.stream()
                .map(AppointmentEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentResources);
    }
    @PostMapping
    public ResponseEntity<AppointmentResource> requestAppointment(@RequestBody CreateAppointmentResource resource) {
        var RequestAppointmentCommand= CreateAppointmentCommandFromResource.resourceToCommand(resource);
        var AppointmentId = appointmentCommandService.handle(RequestAppointmentCommand);

        var Appointment = appointmentCommandService.handle(AppointmentId);

        var appointmentResource = AppointmentEntityToResource.toResourceFromEntity(Appointment.get());
        return new ResponseEntity<>(appointmentResource, HttpStatus.CREATED);
    }

    @PostMapping("/{appointmentId}/confirmations")
    public ResponseEntity<?> confirmAppointment(@PathVariable Long appointmentId) {
        var confirmAppointmentCommand = new ConfirmAppointmentCommand(appointmentId);
        var confirmedAppointmentId = appointmentCommandService.handle(confirmAppointmentCommand);
        return ResponseEntity.ok(confirmedAppointmentId);
    }
    @PostMapping("/{appointmentId}/rejections")
    public ResponseEntity<?> rejectAppointment(@PathVariable Long appointmentId) {
        var rejectAppointmentCommand = new RejectAppointmentCommand(appointmentId);
        var rejectAppointmentId = appointmentCommandService.handle(rejectAppointmentCommand);
        return ResponseEntity.ok(rejectAppointmentId);
    }
    @PostMapping("/{appointmentId}/cancellations")
    public ResponseEntity<?> cancelAppointment(@PathVariable Long appointmentId) {
        var cancelAppointmentCommand = new CancelAppointmentCommand(appointmentId);
        var cancelAppointmentId = appointmentCommandService.handle(cancelAppointmentCommand);
        return ResponseEntity.ok(cancelAppointmentId);
    }


}
