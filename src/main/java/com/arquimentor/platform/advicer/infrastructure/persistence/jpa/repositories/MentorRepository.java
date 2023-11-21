package com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.advicer.domain.model.aggregates.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor,Long> {


}
