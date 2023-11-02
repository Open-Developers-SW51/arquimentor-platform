package com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor,Long> {


}
