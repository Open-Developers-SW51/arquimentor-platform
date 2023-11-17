package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.commands.*;
import com.arquimentor.platform.arquimentor.domain.services.PublicationCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {
    private final PublicationRepository publicationRepository;
    private final MentorProfileRepository mentorProfileRepository;
    public PublicationCommandServiceImpl(PublicationRepository publicationRepository, MentorProfileRepository mentorProfileRepository) {
        this.publicationRepository = publicationRepository;
        this.mentorProfileRepository = mentorProfileRepository;
    }


    @Override
    public Long handle(CreatePublicationCommand command) {
        MentorProfile mentorProfile = mentorProfileRepository.findById(command.mentorProfileId()).orElseThrow();
        var publication = new Publication(command.title(),command.description(),command.images(),mentorProfile);
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
    public List<Publication> findPublicationsByIdMentor(Long findByMentorProfileId) {

        return publicationRepository.findByMentorProfileId(findByMentorProfileId);
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

    @Override
    public Long incrementedView(IncrementViewPublicationCommand command) {
        publicationRepository.findById(command.publicationId())
                .map(publication -> {
                    publication.incrementView();
                    publicationRepository.save(publication);
                    return publication.getId();
                }).orElseThrow(()-> new RuntimeException("Publication not found"));
        return null;
    }

    @Override
    public Long incrementedLike(IncrementedLikePublicationCommand command) {
        publicationRepository.findById(command.publicationId())
                .map(publication -> {
                    publication.incrementLike();
                    publicationRepository.save(publication);
                    return publication.getId();
                }).orElseThrow(()-> new RuntimeException("Publication not found"));
        return null;
    }

    @Override
    public Long discountLike(IncrementedLikePublicationCommand command) {
        publicationRepository.findById(command.publicationId())
                .map(publication -> {
                    publication.discountLike();
                    publicationRepository.save(publication);
                    return publication.getId();
                }).orElseThrow(()-> new RuntimeException("Publication not found"));
        return null;
    }
}
