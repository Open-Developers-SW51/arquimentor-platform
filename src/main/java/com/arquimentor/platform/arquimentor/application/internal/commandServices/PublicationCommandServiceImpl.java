package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationCommand;
import com.arquimentor.platform.arquimentor.domain.services.PublicationCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.PublicationRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {
    private final PublicationRepository publicationRepository;
    private final StudentRepository studentRepository;
    public PublicationCommandServiceImpl(PublicationRepository publicationRepository, StudentRepository studentRepository) {
        this.publicationRepository = publicationRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public Long handle(CreatePublicationCommand command) {
        Student student = studentRepository.findById(command.studentId())
                .orElseThrow();
        var publication = new Publication(command.title(),command.description(),command.images(), command.telephone(),student);
        publicationRepository.save(publication);
        return publication.getId();
    }

    @Override
    public Optional<Publication> handle(Long id){
        return publicationRepository.findById(id);
    }

}
