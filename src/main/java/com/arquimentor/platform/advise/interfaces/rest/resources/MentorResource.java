package com.arquimentor.platform.advise.interfaces.rest.resources;

import com.arquimentor.platform.advise.domain.model.aggregates.Student;

public record MentorResource(
        Long id,
        String subscription,
        Student idStudent
) {


}
