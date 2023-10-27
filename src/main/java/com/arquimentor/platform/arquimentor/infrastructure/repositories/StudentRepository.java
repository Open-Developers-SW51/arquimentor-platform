package com.arquimentor.platform.arquimentor.infrastructure.repositories;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //Ya contiene el CRUD básico

}
