package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.exceptions.StudentNotExceptions;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentCommand;
import com.arquimentor.platform.arquimentor.domain.services.StudentCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentRepository;

public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;
    Student student;
    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Long handle(CreateStudentCommand command) {
        if(studentRepository.findAll().isEmpty()){
            throw new StudentNotExceptions();
        }
        /*studentRepository.findAll();
        Student student = new Student();
        studentRepository.save(student);*/
        return null;
    }
}
