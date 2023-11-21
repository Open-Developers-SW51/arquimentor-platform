package com.arquimentor.platform.advicer.application.internal.queryservices;

import com.arquimentor.platform.advicer.domain.model.aggregates.Student;
import com.arquimentor.platform.advicer.domain.model.queries.GetStudentByEmailQuery;
import com.arquimentor.platform.advicer.domain.model.queries.GetStudentByIdQuery;
import com.arquimentor.platform.advicer.domain.services.StudentQueryService;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.StudentRepository;
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
    public Optional<Student> handle(GetStudentByEmailQuery query) {
        return studentRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Student> handle(GetStudentByIdQuery query) {
        return studentRepository.findById(query.StudentId());
    }

    @Override
    public Optional<Student> porId(Long id) {
        return studentRepository.findById(id);
    }


    public List<Student> findAll(){
        return studentRepository.findAll();
    }
}
