package com.arquimentor.platform.advise.domain.services.queries;
import com.arquimentor.platform.advise.domain.model.aggregates.Student;
import com.arquimentor.platform.advise.domain.model.queries.GetStudentByEmailQuery;
import com.arquimentor.platform.advise.domain.model.queries.GetStudentByIdQuery;

import java.util.List;
import java.util.Optional;


public interface StudentQueryService {
    Optional<Student> findStudentByEmail(GetStudentByEmailQuery query);
    Optional<Student> findStudentById(GetStudentByIdQuery query);
    List<Student>findAllStudents();
}
