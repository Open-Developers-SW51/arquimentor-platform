package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationNotTelephoneCommand;

public interface PublicationCommandService {
    Long handle(CreatePublicationCommand command);
    Long handle(CreatePublicationNotTelephoneCommand command);
}
