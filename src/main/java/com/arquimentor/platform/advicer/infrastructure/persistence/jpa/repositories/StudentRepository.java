package com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.advicer.domain.model.aggregates.Student;
import com.arquimentor.platform.advicer.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Ya contiene el CRUD básico de una tabla

    Optional<Student> findByEmail(EmailAddress emailAddress);

}
