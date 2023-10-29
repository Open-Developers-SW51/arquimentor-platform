package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationNotTelephoneCommand;
import com.arquimentor.platform.arquimentor.domain.services.PublicationCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {
    private final PublicationRepository publicationRepository;

    public PublicationCommandServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Long handle(CreatePublicationCommand command) {
        var publication = new Publication(command.title(),command.description(),command.carousel(),command.telephone());
        publicationRepository.save(publication);
        return publication.getId();
    }

    @Override
    public Long handle(CreatePublicationNotTelephoneCommand command) {
        var publication = new Publication(command.title(),command.description(),command.carousel());
        publicationRepository.save(publication);
        return publication.getId();
    }
}
