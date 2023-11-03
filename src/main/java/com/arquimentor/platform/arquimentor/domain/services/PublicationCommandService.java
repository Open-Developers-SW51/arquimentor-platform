package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationCommand;

import java.util.List;
import java.util.Optional;

public interface PublicationCommandService {
    Long handle(CreatePublicationCommand command);
    Optional<Publication> handle(Long idPublication);
    List<Publication> findAll();

    List<Publication> findPublicationsByIdMentor(Long idPublication);

    Optional<Publication> findPublicationById(Long idPublication);
}
