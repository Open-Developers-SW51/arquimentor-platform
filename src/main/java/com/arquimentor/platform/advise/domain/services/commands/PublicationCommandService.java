package com.arquimentor.platform.advise.domain.services.commands;

import com.arquimentor.platform.advise.domain.model.aggregates.Publication;
import com.arquimentor.platform.advise.domain.model.commands.*;

import java.util.List;
import java.util.Optional;

public interface PublicationCommandService {
    Long createPublication(CreatePublicationCommand command);

    Optional<Publication> updatePublicationById(UpdatePublicationCommand command);

    void deletePublication(DeletePublicationCommand command);

    Long incrementView(IncrementViewPublicationCommand command);

    Long incrementLike(IncrementedLikePublicationCommand command);

    Long discountLike(IncrementedLikePublicationCommand command);

}
