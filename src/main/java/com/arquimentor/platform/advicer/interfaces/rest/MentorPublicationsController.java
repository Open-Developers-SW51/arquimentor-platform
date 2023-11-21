package com.arquimentor.platform.advicer.interfaces.rest;

import com.arquimentor.platform.advicer.domain.services.PublicationCommandService;
import com.arquimentor.platform.advicer.interfaces.rest.resources.PublicationResource;
import com.arquimentor.platform.advicer.interfaces.rest.transform.PublicationEntityToResource;
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
@RequestMapping(value = "/api/v1/mentors/{mentorId}/publications", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Mentors")
public class MentorPublicationsController {
    private final PublicationCommandService publicationCommandService;

    public MentorPublicationsController(PublicationCommandService publicationCommandService) {
        this.publicationCommandService = publicationCommandService;
    }
    @GetMapping
    public ResponseEntity<List<PublicationResource>> getPublicationsByIdMentor(@PathVariable Long mentorId) {
        var listPublications=publicationCommandService.findPublicationsByIdMentor(mentorId);
        List<PublicationResource> publicationResources = listPublications.stream()
                .map(PublicationEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publicationResources);
    }
}
