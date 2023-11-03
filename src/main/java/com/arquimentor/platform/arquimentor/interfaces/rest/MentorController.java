package com.arquimentor.platform.arquimentor.interfaces.rest;

import com.arquimentor.platform.arquimentor.domain.services.MentorCommandService;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateMentorResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.MentorResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.CreateMentorCommandFromResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.MentorEntityToResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/mentors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mentors", description = "Mentors Management Endpoints")
public class MentorController {

    private final MentorCommandService mentorCommandSerice;

    public MentorController(MentorCommandService mentorCommandSerice) {
        this.mentorCommandSerice = mentorCommandSerice;
    }

    @PostMapping
    public ResponseEntity<MentorResource> createUserMentor(@RequestBody CreateMentorResource resource){
        var createMentorCommand = CreateMentorCommandFromResource.resourceToCommand(resource);
        var MentorId = mentorCommandSerice.handle(createMentorCommand);
        if(MentorId == 0L){
            return ResponseEntity.badRequest().build();
        }

        var userMentor = mentorCommandSerice.handle(MentorId);

        if (userMentor.isEmpty()) return ResponseEntity.badRequest().build();

        var MentorResource = MentorEntityToResource.EntityToResource(userMentor.get());
        return new ResponseEntity<>(MentorResource, HttpStatus.CREATED);
    }
}
