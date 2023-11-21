package com.arquimentor.platform.advicer.domain.model.commands;

import java.util.List;

public record CreatePublicationCommand(
        String title,
        String description,
        List<String> images,
        Long mentorProfileId
) {
}
