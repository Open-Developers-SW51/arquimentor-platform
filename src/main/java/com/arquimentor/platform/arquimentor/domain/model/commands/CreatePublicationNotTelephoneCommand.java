package com.arquimentor.platform.arquimentor.domain.model.commands;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.Carousel;

public record CreatePublicationNotTelephoneCommand(
        String title,
        String description,
        Carousel carousel,
        Student student
) {

}
