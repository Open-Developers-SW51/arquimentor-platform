package com.arquimentor.platform.advise.domain.model.commands;

import java.util.List;

public record UpdatePublicationCommand(

        Long id,
        String title,
        String description,
        List<String> images
) {
}
