package com.arquimentor.platform.advicer.application.internal.commandServices;

import com.arquimentor.platform.advicer.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advicer.domain.model.aggregates.Student;
import com.arquimentor.platform.advicer.domain.model.commands.CreateMentorCommand;
import com.arquimentor.platform.advicer.domain.services.MentorCommandService;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.StudentRepository;
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
    public Long handle(CreateMentorCommand command) {
        Student student = studentRepository.findById(command.studentId()).orElseThrow();;
        var Mentor = new Mentor(command.subscription(),student);
        mentorRepository.save(Mentor);
        return Mentor.getId();
    }

    @Override
    public Optional<Mentor> handle(Long idMentor) {
        return mentorRepository.findById(idMentor);
    }
}
