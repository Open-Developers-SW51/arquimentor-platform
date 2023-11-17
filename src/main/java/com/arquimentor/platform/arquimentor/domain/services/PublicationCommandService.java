package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.commands.*;

import java.util.List;
import java.util.Optional;

public interface PublicationCommandService {
    Long handle(CreatePublicationCommand command);
    Optional<Publication> handle(Long idPublication);
    List<Publication> findAll();

    List<Publication> findPublicationsByIdMentor(Long idMentor);

    Optional<Publication> findPublicationById(Long idPublication);

    Optional<Publication> updatePublicationById(UpdatePublicationCommand command);

    void deletePublication(DeletePublicationCommand command);

    Long incrementedView(IncrementViewPublicationCommand command);

    Long incrementedLike(IncrementedLikePublicationCommand command);

    Long discountLike(IncrementedLikePublicationCommand command);

}
