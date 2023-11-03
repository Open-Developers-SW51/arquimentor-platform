package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreatePublicationCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.DeletePublicationCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.UpdatePublicationCommand;
import com.arquimentor.platform.arquimentor.domain.services.PublicationCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.MentorRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.PublicationRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {
    private final PublicationRepository publicationRepository;
    private final MentorRepository mentorRepository;
    public PublicationCommandServiceImpl(PublicationRepository publicationRepository, MentorRepository mentorRepository) {
        this.publicationRepository = publicationRepository;
        this.mentorRepository = mentorRepository;
    }


    @Override
    public Long handle(CreatePublicationCommand command) {
        Mentor mentor = mentorRepository.findById(command.mentorId())
                .orElseThrow();
        var publication = new Publication(command.title(),command.description(),command.images(),mentor);
        publicationRepository.save(publication);
        return publication.getId();
    }

    @Override
    public Optional<Publication> handle(Long id){
        return publicationRepository.findById(id);
    }

    @Override
    public List<Publication> findAll(){
        return publicationRepository.findAll();
    }

    @Override
    public List<Publication> findPublicationsByIdMentor(Long idMentor) {

        return publicationRepository.findByMentorId(idMentor);
    }

    @Override
    public Optional<Publication> findPublicationById(Long idPublication) {
        return publicationRepository.findById(idPublication);
    }

    @Override
    public Optional<Publication> updatePublicationById(UpdatePublicationCommand command) {
        if (!publicationRepository.existsById(command.id()))throw new IllegalArgumentException("Publication does not exist");
        var publicationToUpdate = publicationRepository.findById(command.id()).get();
        var updatePublication = publicationRepository.save(publicationToUpdate.updatePublication(command.title(),command.description(), command.images()));
        return Optional.of(updatePublication);
    }

    @Override
    public void deletePublication(DeletePublicationCommand command) {
        if (!publicationRepository.existsById(command.publicationId())){
            throw new IllegalArgumentException("Publication does not exist");
        }
        publicationRepository.deleteById(command.publicationId());
    }
}
