package com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

    //Ya contiene el CRUD básico de una tabla

    List<Publication> findByMentorProfileId(Long idMentorProfile);
}
