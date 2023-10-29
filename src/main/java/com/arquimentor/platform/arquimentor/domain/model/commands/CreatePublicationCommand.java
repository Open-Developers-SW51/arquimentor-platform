package com.arquimentor.platform.arquimentor.domain.model.commands;

import java.util.List;

public record CreatePublicationCommand(
        String title,
        String description,
        List<String> images,
        String telephone,
        Long studentId
) {
}
