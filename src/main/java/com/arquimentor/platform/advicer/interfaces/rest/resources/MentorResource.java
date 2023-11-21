package com.arquimentor.platform.advicer.interfaces.rest.resources;

import com.arquimentor.platform.advicer.domain.model.aggregates.Student;

public record MentorResource(
        Long id,
        String subscription,
        Student idStudent
) {


}
