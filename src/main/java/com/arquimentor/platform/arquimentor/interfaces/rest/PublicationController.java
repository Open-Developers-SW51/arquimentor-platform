package com.arquimentor.platform.arquimentor.interfaces.rest;

import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByIdQuery;
import com.arquimentor.platform.arquimentor.domain.services.PublicationCommandService;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreatePublicationResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.PublicationResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.CreatePublicationCommandFromResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.PublicationEntityToResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/publications", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Publications", description = "Student Management Endpoints")
public class PublicationController {
    private final PublicationCommandService publicationCommandService;

    public PublicationController(PublicationCommandService publicationCommandService) {
        this.publicationCommandService = publicationCommandService;
    }
    @GetMapping
    public ResponseEntity<List<PublicationResource>> getPublications() {
        var listPublications=publicationCommandService.findAll();
        List<PublicationResource> publicationResources = listPublications.stream()
                .map(PublicationEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publicationResources);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<PublicationResource>> getPublicationsByIdMentor(@PathVariable Long studentId) {
        var listPublications=publicationCommandService.findPublicationsByIdMentor(studentId);
        List<PublicationResource> publicationResources = listPublications.stream()
                .map(PublicationEntityToResource::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publicationResources);
    }
    @PostMapping
    public ResponseEntity<PublicationResource> createPublication(@RequestBody CreatePublicationResource resource) {
        var CreatePublicationCommand = CreatePublicationCommandFromResource.resourceToCommand(resource);
        var publicationId = publicationCommandService.handle(CreatePublicationCommand);
        if (publicationId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var publication = publicationCommandService.handle(publicationId);

        if (publication.isEmpty()) return ResponseEntity.badRequest().build();

        var studentResource = PublicationEntityToResource.toResourceFromEntity(publication.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }
}
