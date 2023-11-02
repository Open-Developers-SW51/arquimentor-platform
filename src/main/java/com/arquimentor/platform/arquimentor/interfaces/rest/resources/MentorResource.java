package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;

public record MentorResource(
        Long id,
        String subscription,
        Student idStudent
) {


}
