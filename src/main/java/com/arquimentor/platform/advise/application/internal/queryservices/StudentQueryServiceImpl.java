package com.arquimentor.platform.advise.application.internal.queryservices;

import com.arquimentor.platform.advise.domain.model.aggregates.Student;
import com.arquimentor.platform.advise.domain.model.queries.GetStudentByEmailQuery;
import com.arquimentor.platform.advise.domain.model.queries.GetStudentByIdQuery;
import com.arquimentor.platform.advise.domain.services.queries.StudentQueryService;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> findStudentByEmail(GetStudentByEmailQuery query) {
        return studentRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Student> findStudentById(GetStudentByIdQuery query) {
        return studentRepository.findById(query.StudentId());
    }
    @Override
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
}
