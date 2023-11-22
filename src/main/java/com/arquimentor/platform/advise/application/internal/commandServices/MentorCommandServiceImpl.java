package com.arquimentor.platform.advise.application.internal.commandServices;

import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advise.domain.model.aggregates.Student;
import com.arquimentor.platform.advise.domain.model.commands.CreateMentorCommand;
import com.arquimentor.platform.advise.domain.services.commands.MentorCommandService;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorCommandServiceImpl implements MentorCommandService {

    private final MentorRepository mentorRepository;
    private final StudentRepository studentRepository;

    public MentorCommandServiceImpl(MentorRepository mentorRepository, StudentRepository studentRepository) {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Long createMentor(CreateMentorCommand command) {
        Student student = studentRepository.findById(command.studentId()).orElseThrow();;
        var Mentor = new Mentor(command.subscription(),student);
        mentorRepository.save(Mentor);
        return Mentor.getId();
    }

}
