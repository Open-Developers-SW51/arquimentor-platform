package com.arquimentor.platform.advicer.interfaces.rest;

import com.arquimentor.platform.advicer.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.advicer.domain.model.commands.CreateMentorProfileCommand;
import com.arquimentor.platform.advicer.domain.model.commands.UpdateMentorProfileCommand;
import com.arquimentor.platform.advicer.domain.model.queries.GetMentorProfileByMentorIdQuery;
import com.arquimentor.platform.advicer.domain.services.MentorProfileCommandService;
import com.arquimentor.platform.advicer.domain.services.MentorProfileQueryService;
import com.arquimentor.platform.advicer.interfaces.rest.resources.*;
import com.arquimentor.platform.advicer.interfaces.rest.transform.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/mentorprofiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mentor Profiles", description = "Mentor Profile Management Endpoints")
public class MentorProfileController {
    private final MentorProfileQueryService mentorProfileQueryService;
    private final MentorProfileCommandService mentorProfileCommandService;

    public MentorProfileController(MentorProfileQueryService mentorProfileQueryService, MentorProfileCommandService mentorProfileCommandService) {
        this.mentorProfileQueryService = mentorProfileQueryService;
        this.mentorProfileCommandService = mentorProfileCommandService;
    }

    @PostMapping
    public ResponseEntity<MentorProfileResource> createMentorProfile(@RequestBody CreateMentorProfileResource resource) {
        CreateMentorProfileCommand command = CreateMentorProfileCommandFromResource.resourceToCommand(resource);
        Long createdMentorProfileId = mentorProfileCommandService.handle(command);

        if (createdMentorProfileId != null) {

            Optional<MentorProfile> createdProfile = mentorProfileCommandService.handle(createdMentorProfileId);

            if (createdProfile.isPresent()) {
               MentorProfileResource profileResource = MentorProfileEntityToResource.toResourceFromEntity(createdProfile.get());
                return ResponseEntity.status(HttpStatus.CREATED).body(profileResource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/{mentorId}")
    public ResponseEntity<MentorProfileResource> getMentorProfileBystudentId(@PathVariable Long mentorId) {
        GetMentorProfileByMentorIdQuery query = new GetMentorProfileByMentorIdQuery(mentorId);
        Optional<MentorProfile> mentorProfile = mentorProfileQueryService.handle(query);

        if (mentorProfile.isPresent()) {
            MentorProfileResource profileResource = MentorProfileEntityToResource.toResourceFromEntity(mentorProfile.get());
            return ResponseEntity.ok(profileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MentorProfileResource>> getAllMentorProfiles() {
        List<MentorProfile> mentorprofiles = mentorProfileCommandService.findAll();

        List<MentorProfileResource> profileResources = mentorprofiles.stream()
                .map(MentorProfileEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(profileResources);
    }

    @PutMapping("/{mentorProfileId}")
    public ResponseEntity<MentorProfileResource> updateMentorProfile(
            @PathVariable Long mentorProfileId,
            @RequestBody UpdateMentorProfileResource resource) {
        UpdateMentorProfileCommand command = UpdateMentorProfileCommandFromResource.toCommandFromResource(mentorProfileId, resource);
        Optional<MentorProfile> updatedProfile = mentorProfileCommandService.updateMentorProfileByID(command);

        if (updatedProfile.isPresent()) {
            MentorProfileResource profileResource = MentorProfileEntityToResource.toResourceFromEntity(updatedProfile.get());
            return ResponseEntity.ok(profileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
