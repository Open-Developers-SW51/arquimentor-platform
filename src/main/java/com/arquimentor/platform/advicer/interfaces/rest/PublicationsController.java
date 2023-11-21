package com.arquimentor.platform.advicer.interfaces.rest;

import com.arquimentor.platform.advicer.domain.model.commands.DeletePublicationCommand;
import com.arquimentor.platform.advicer.domain.model.commands.IncrementViewPublicationCommand;
import com.arquimentor.platform.advicer.domain.model.commands.IncrementedLikePublicationCommand;
import com.arquimentor.platform.advicer.domain.services.PublicationCommandService;
import com.arquimentor.platform.advicer.interfaces.rest.resources.CreatePublicationResource;
import com.arquimentor.platform.advicer.interfaces.rest.resources.PublicationResource;
import com.arquimentor.platform.advicer.interfaces.rest.resources.UpdatePublicationResource;
import com.arquimentor.platform.advicer.interfaces.rest.transform.CreatePublicationCommandFromResource;
import com.arquimentor.platform.advicer.interfaces.rest.transform.PublicationEntityToResource;
import com.arquimentor.platform.advicer.interfaces.rest.transform.UpdatePublicationCommandFromResource;
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
public class PublicationsController {
    private final PublicationCommandService publicationCommandService;

    public PublicationsController(PublicationCommandService publicationCommandService) {
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

    @GetMapping("/{publicationId}")
    public ResponseEntity<PublicationResource> getPublicationById(@PathVariable Long publicationId) {
        var publication=publicationCommandService.findPublicationById(publicationId);
        var publicationResources = PublicationEntityToResource.toResourceFromEntity(publication.get());
        return ResponseEntity.ok(publicationResources);
    }
    @PostMapping
    public ResponseEntity<PublicationResource> createPublication(
            @RequestBody CreatePublicationResource resource
    ) {
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

    @PutMapping("/{publicationId}")
    public ResponseEntity<PublicationResource> updatePublication(@PathVariable Long publicationId, @RequestBody UpdatePublicationResource updatePublicationResource) {
        var updatePublicationCommand = UpdatePublicationCommandFromResource.toCommandFromResource(publicationId, updatePublicationResource);
        var updatedPublication = publicationCommandService.updatePublicationById(updatePublicationCommand);
        if (updatedPublication.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var publicationResource = PublicationEntityToResource.toResourceFromEntity(updatedPublication.get());
        return ResponseEntity.ok(publicationResource);
    }

    @DeleteMapping("/{publicationId}")
    public ResponseEntity<?> deletePublication(@PathVariable Long publicationId) {
        var deletePublicationCommand = new DeletePublicationCommand(publicationId);
        publicationCommandService.deletePublication(deletePublicationCommand);
        return ResponseEntity.ok("Publication with given id successfully deleted");
    }

    @PostMapping("/{publicationId}/incrementView")
    public ResponseEntity<?> incrementViewPublication(@PathVariable Long publicationId) {
        var incrementViewPublicationCommand = new IncrementViewPublicationCommand(publicationId);
        var incrementViewPublicationId = publicationCommandService.incrementedView(incrementViewPublicationCommand);
        return ResponseEntity.ok(incrementViewPublicationId);
    }

    @PostMapping("/{publicationId}/incrementLike")
    public ResponseEntity<?> incrementLikePublication(@PathVariable Long publicationId) {
        var incrementLikePublicationCommand = new IncrementedLikePublicationCommand(publicationId);
        var incrementLikePublicationId = publicationCommandService.incrementedLike(incrementLikePublicationCommand);
        return ResponseEntity.ok(incrementLikePublicationId);
    }

    @PostMapping("/{publicationId}/discountLike")
    public ResponseEntity<?> discountLikePublication(@PathVariable Long publicationId) {
        var incrementLikePublicationCommand = new IncrementedLikePublicationCommand(publicationId);
        var incrementLikePublicationId = publicationCommandService.discountLike(incrementLikePublicationCommand);
        return ResponseEntity.ok(incrementLikePublicationId);
    }
}
