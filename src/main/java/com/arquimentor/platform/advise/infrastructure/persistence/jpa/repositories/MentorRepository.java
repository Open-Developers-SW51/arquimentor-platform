package com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor,Long> {


}
