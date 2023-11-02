package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateMentorCommand;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.Subscription;
import com.arquimentor.platform.arquimentor.domain.services.MentorCommandSerice;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentRepository;

public class MentorCommandServiceImpl implements MentorCommandSerice {

    private final MentorRepository mentorRepository;
    private final StudentRepository studentRepository;

    public MentorCommandServiceImpl(MentorRepository mentorRepository, StudentRepository studentRepository) {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Long handle(CreateMentorCommand command) {
        Student student = studentRepository.findById(command.studentId()).orElseThrow();;
        var Mentor = new Mentor(command.subscription(),student);
        return null;
    }
}
