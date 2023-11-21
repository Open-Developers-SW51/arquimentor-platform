package com.arquimentor.platform.advicer.application.internal.queryservices;

import com.arquimentor.platform.advicer.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.advicer.domain.model.queries.GetStudentProfileByStudentIdQuery;
import com.arquimentor.platform.advicer.domain.services.StudentProfileQueryService;
import com.arquimentor.platform.advicer.infrastructure.persistence.jpa.repositories.StudentProfileRepository;
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
    public Optional<StudentProfile> handle(GetStudentProfileByStudentIdQuery query) {

        List<StudentProfile> profiles = studentProfileRepository.findByStudentId(query.StudentId());
        return profiles.isEmpty() ? Optional.empty() : Optional.of(profiles.get(0));
    }
    public List<StudentProfile> findAll(){
        return studentProfileRepository.findAll();
    }


   // @Override
   // public Optional<StudentProfile> handle(GetStudentProfileByPhoneNumberQuery query) {
     //   return studentProfileRepository.findStudentProfilesByPhoneNumber(query.phoneNumber());
  //  }
 }
