package com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    //Ya contiene el CRUD básico de una tabla

}
