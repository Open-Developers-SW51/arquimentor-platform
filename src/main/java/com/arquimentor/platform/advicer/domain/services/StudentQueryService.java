package com.arquimentor.platform.advicer.domain.services;

import com.arquimentor.platform.advicer.domain.model.aggregates.Student;
import com.arquimentor.platform.advicer.domain.model.queries.GetStudentByEmailQuery;
import com.arquimentor.platform.advicer.domain.model.queries.GetStudentByIdQuery;

import java.util.Optional;


public interface StudentQueryService {
    Optional<Student> handle(GetStudentByEmailQuery query);
    Optional<Student> handle(GetStudentByIdQuery query);
    Optional<Student> porId(Long id);

}
