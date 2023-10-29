package com.arquimentor.platform.arquimentor.domain.model.commands;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.Carousel;

public record CreatePublicationCommand(
        String title,
        String description,
        Carousel carousel,
        String telephone,
        Student student
) {
}
