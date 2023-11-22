package com.arquimentor.platform.advise.application.internal.queryservices;

import com.arquimentor.platform.advise.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.advise.domain.model.queries.GetStudentProfileByStudentIdQuery;
import com.arquimentor.platform.advise.domain.services.queries.StudentProfileQueryService;
import com.arquimentor.platform.advise.infrastructure.persistence.jpa.repositories.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentProfileQueryServiceImpl implements StudentProfileQueryService {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileQueryServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public Optional<StudentProfile> findStudentProfileByStudentId(GetStudentProfileByStudentIdQuery query) {

        List<StudentProfile> profiles = studentProfileRepository.findByStudentId(query.StudentId());
        return profiles.isEmpty() ? Optional.empty() : Optional.of(profiles.get(0));
    }

    @Override
    public List<StudentProfile> findAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }


   // @Override
   // public Optional<StudentProfile> handle(GetStudentProfileByPhoneNumberQuery query) {
     //   return studentProfileRepository.findStudentProfilesByPhoneNumber(query.phoneNumber());
  //  }
 }
