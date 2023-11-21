package com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.advicer.domain.model.aggregates.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

    //Ya contiene el CRUD básico de una tabla

    List<Publication> findByMentorProfileId(Long idMentorProfile);
}
