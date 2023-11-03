package com.arquimentor.platform.arquimentor.interfaces.rest;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.UpdateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentProfileByStudentIdQuery;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileCommandService;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileQueryService;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.UpdateStudentProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.CreateStudentProfileCommandFromResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.StudentProfileEntityToResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.UpdateStudentProfileCommandFromResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/studentprofiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Student Profiles", description = "Student Profile Management Endpoints")
public class StudentProfileController {
    private final StudentProfileQueryService studentProfileQueryService;
    private final StudentProfileCommandService studentProfileCommandService;

    public StudentProfileController(StudentProfileQueryService studentProfileQueryService, StudentProfileCommandService studentProfileCommandService) {
        this.studentProfileQueryService = studentProfileQueryService;
        this.studentProfileCommandService = studentProfileCommandService;
    }

    @PostMapping
    public ResponseEntity<StudentProfileResource> createStudentProfile(@RequestBody CreateStudentProfileResource resource) {
        CreateStudentProfileCommand command = CreateStudentProfileCommandFromResource.resourceToCommand(resource);
        Long createdStudentProfileId = studentProfileCommandService.handle(command);

        if (createdStudentProfileId != null) {

            var getStudentProfileByStudentIdQuery = new GetStudentProfileByStudentIdQuery(createdStudentProfileId);
            Optional<StudentProfile> createdProfile = studentProfileCommandService.handle(createdStudentProfileId);

            if (createdProfile.isPresent()) {
                StudentProfileResource profileResource = StudentProfileEntityToResource.toResourceFromEntity(createdProfile.get());
                return ResponseEntity.status(HttpStatus.CREATED).body(profileResource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/{studentId}")
    public ResponseEntity<StudentProfileResource> getStudentProfileBystudentId(@PathVariable Long studentId) {
        GetStudentProfileByStudentIdQuery query = new GetStudentProfileByStudentIdQuery(studentId);
        Optional<StudentProfile> studentProfile = studentProfileQueryService.handle(query);

        if (studentProfile.isPresent()) {
            StudentProfileResource profileResource = StudentProfileEntityToResource.toResourceFromEntity(studentProfile.get());
            return ResponseEntity.ok(profileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<StudentProfileResource>> getAllStudentProfiles() {
        List<StudentProfile> studentprofiles = studentProfileCommandService.findAll();

        List<StudentProfileResource> profileResources = studentprofiles.stream()
                .map(StudentProfileEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(profileResources);
    }

    @PutMapping("/{studentProfileId}")
    public ResponseEntity<StudentProfileResource> updateStudentProfile(
            @PathVariable Long studentProfileId,
            @RequestBody UpdateStudentProfileResource resource) {
        UpdateStudentProfileCommand command = UpdateStudentProfileCommandFromResource.toCommandFromResource(studentProfileId, resource);
        Optional<StudentProfile> updatedProfile = studentProfileCommandService.updateStudentProfileByID(command);

        if (updatedProfile.isPresent()) {
            StudentProfileResource profileResource = StudentProfileEntityToResource.toResourceFromEntity(updatedProfile.get());
            return ResponseEntity.ok(profileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
