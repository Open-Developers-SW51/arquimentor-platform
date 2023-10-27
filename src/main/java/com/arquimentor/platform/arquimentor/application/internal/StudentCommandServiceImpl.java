package com.arquimentor.platform.arquimentor.application.internal;

import com.arquimentor.platform.arquimentor.domain.exceptions.StudentNotExceptions;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.commands.StudentCommand;
import com.arquimentor.platform.arquimentor.domain.services.StudentCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.repositories.StudentRepository;

public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;
    Student student;
    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Long handle(StudentCommand command) {
        if(studentRepository.findAll().isEmpty()){
            throw new StudentNotExceptions();
        }
        /*studentRepository.findAll();
        Student student = new Student();
        studentRepository.save(student);*/
        return command.student().getId();
    }
}
