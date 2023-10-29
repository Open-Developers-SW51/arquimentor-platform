package com.arquimentor.platform.arquimentor.domain.model.commands;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.Carousel;

public record CreatePublicationCommand(
        String title,
        String description,
        String image,
        String telephone,
        Long studentId
) {
}
