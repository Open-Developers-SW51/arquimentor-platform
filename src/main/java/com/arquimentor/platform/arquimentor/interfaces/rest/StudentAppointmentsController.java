package com.arquimentor.platform.arquimentor.interfaces.rest;

import com.arquimentor.platform.arquimentor.domain.services.AppointmentCommandService;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.AppointmentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.AppointmentEntityToResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/student/{studentId}/appointments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Students")
public class StudentAppointmentsController {
    private final AppointmentCommandService appointmentCommandService;

    public StudentAppointmentsController(AppointmentCommandService appointmentCommandService) {
        this.appointmentCommandService = appointmentCommandService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResource>> getAppointmentsByIdStudent(@PathVariable Long studentId) {
        var listAppointments=appointmentCommandService.findAppointmentsByStudentId(studentId);
        List<AppointmentResource> appointmentResources = listAppointments.stream()
                .map(AppointmentEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentResources);
    }
}
